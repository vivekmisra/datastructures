package org.vivek.myinterview.strings.problems.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubDomainVisit {

	public static void main(String[] args) {
		String[] cpdomains = { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" };
		SubDomainVisit sv = new SubDomainVisit();
		List<String> visits = sv.subdomainVisits(cpdomains);
		for (String visit : visits) {
			System.out.println(visit);
		}
	}
	
	 public List<String> subdomainVisits(String[] cpdomains) {
	        Map<String, Integer> counts = new HashMap();
	        for (String domain: cpdomains) {
	            String[] cpinfo = domain.split("\\s+");//space
	            int count = Integer.valueOf(cpinfo[0]);
	            
	            String[] frags = cpinfo[1].split("\\.");
	          
	            String cur = "";
	            for (int i = frags.length - 1; i >= 0; --i) {
	                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
	                counts.put(cur, counts.getOrDefault(cur, 0) + count);
	            }
	        }

	        List<String> ans = new ArrayList();
	        for (String dom: counts.keySet())
	            ans.add("" + counts.get(dom) + " " + dom);
	        return ans;
	    }

	public static List<String> subdomainVisits2(String[] cpdomains) {
		List<String> subDomainVisits = new ArrayList<String>();
		for (String domainString : cpdomains) {
			Domain d = parseDomain(domainString);
			subDomainVisits.add(d.getDomainDescription());
			subDomainVisits = parseSubDomains(d, subDomainVisits);

		}
		return subDomainVisits;

	}

	private static Domain parseDomain(String domainString) {
		String[] domainArray = domainString.split(" ");
		Integer visitedCount = Integer.valueOf(domainArray[0]);
		String domainName = domainArray[1];
		String subDomainVisit = visitedCount + " " + domainName;
		Domain d = new Domain(visitedCount, domainName);
		d.setDomainDescription(subDomainVisit);
		return d;

	}

	static List<String> parseSubDomains(Domain domain, List<String> subDomainVisits) {
		if (domain.getName().lastIndexOf(".") != -1) {
			domain = parseDomainString(domain, subDomainVisits);
		}
		return subDomainVisits;
	}

	private static Domain parseDomainString(Domain domain, List<String> subDomainVisits) {
		String domainName = domain.getName();
		if (domainName != null) {
			if (domainName.lastIndexOf(".") != -1) {
				Integer visitedCount = domain.getVisitedCount();
				int indx = domainName.indexOf(".");
				String subDomainName = domainName.substring(indx + 1, domainName.length());
				String subDomainVisit = visitedCount + " " + subDomainName;
				Domain d = new Domain(visitedCount, subDomainName);
				d.setDomainDescription(subDomainVisit);
				subDomainVisits.add(d.getDomainDescription());
				domain.addSubDomains(d);
				parseDomainString(d, subDomainVisits);
			} else {
				domain.setSubDomains(null);
				return domain;
			}
		} else {
			domain.addSubDomains(null);
			return domain;
		}
		return domain;

	}

	private static void checkAndUpdateVisitedCount(List<String> subDomainVisits, Integer visitedCount,
			String subDomainName) {
		for (String subDomainVisit : subDomainVisits) {
			if (subDomainVisit.contains(subDomainName)) {
				visitedCount = visitedCount + 1;
				subDomainVisit = subDomainVisit.replace(visitedCount.toString(), (visitedCount).toString());
			}
		}

	}

	static class Domain {
		Integer visitedCount;
		String name;
		String domainDescription;

		public Domain() {

		}

		public Domain(Integer visitedCount, String name) {
			this.visitedCount = visitedCount;
			this.name = name;
		}

		public String getDomainDescription() {
			return domainDescription;
		}

		public void setDomainDescription(String domainDescription) {
			this.domainDescription = domainDescription;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		List<Domain> subDomains = new ArrayList<Domain>();

		public Integer getVisitedCount() {
			return visitedCount;
		}

		public void setVisitedCount(Integer visitedCount) {
			this.visitedCount = visitedCount;
		}

		public List<Domain> getSubDomains() {
			return subDomains;
		}

		public void setSubDomains(List<Domain> subDomains) {
			this.subDomains = subDomains;
		}

		public void addSubDomains(Domain domain) {
			domain.setVisitedCount(getVisitedCount());
			subDomains.add(domain);
		}

		@Override
		public String toString() {
			return "Domain [visitedCount=" + visitedCount + ", name=" + name + ", domainDescription="
					+ domainDescription + ", subDomains=" + subDomains + "]";
		}

	}

}
