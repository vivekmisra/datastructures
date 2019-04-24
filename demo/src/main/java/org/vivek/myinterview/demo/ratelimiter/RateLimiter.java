package org.vivek.myinterview.demo.ratelimiter;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Whenever you expose a web service / api endpoint, you need 
 * to implement a rate limiter to prevent abuse
 *  of the service (DOS attacks).

Implement a RateLimiter Class with an isAllow method. 
Every request comes in with a unique clientID,
 deny a request if that client has made more than 100 requests in the past second.
 */

public class RateLimiter {

	private final Map<String, ReqQueu> clientIdTimeStampMap = new ConcurrentHashMap<>();
	private static int REQUEST_LIMIT = 100;
	private static int TIME_LIMIT = 1; // second

	public boolean isAllow(String clientId) {
		Optional<Map.Entry<String, ReqQueu>> first = clientIdTimeStampMap.entrySet().stream()
				.filter(x -> x.getKey().equals(clientId)).findFirst();
		ReqQueu reqQueu;
		if (first.isPresent()) {
			reqQueu = first.get().getValue();
		} else {
			reqQueu = new ReqQueu();
			clientIdTimeStampMap.put(clientId, reqQueu);
		}
		if (reqQueu.isFirstReqBeforeSec(TIME_LIMIT)) {
			reqQueu.reset();
		}
		if (reqQueu.getTotalReq() >= REQUEST_LIMIT) {
			return false;
		}
		reqQueu.put(System.currentTimeMillis());
		return true;
	}

	public int getReqNumber(String clientId) {
		return clientIdTimeStampMap.get(clientId).getTotalReq();
	}

	private static class ReqQueu {
		private long[] timeStamps = new long[REQUEST_LIMIT];
		private int counter = 0;

		public void put(long timeStamp) {
			timeStamps[counter] = timeStamp;
			counter++;
		}

		public boolean isFirstReqBeforeSec(int sec) {
			long currentTimeMillis = System.currentTimeMillis();
			long firstReqMiliSec = timeStamps[0];
			if (firstReqMiliSec != 0) {
				long difference = currentTimeMillis - firstReqMiliSec;
				return (difference / 1000) >= sec ? true : false;
			} else {
				return false;
			}
		}

		public void reset() {
			timeStamps = new long[REQUEST_LIMIT];
			counter = 0;
		}

		public int getTotalReq() {
			return counter;
		}
	}
}
