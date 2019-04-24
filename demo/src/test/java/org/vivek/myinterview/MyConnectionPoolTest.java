package org.vivek.myinterview;
import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;
import org.vivek.myinterview.demo.connectionpool.IConnectionPool;
import org.vivek.myinterview.demo.connectionpool.MyConnectionPool;
public class MyConnectionPoolTest {
	 private static MyConnectionPool connectionPool;

	    @BeforeClass
	    public static void setUpMyConnectionPoolInstance() throws SQLException {
	        connectionPool = MyConnectionPool.create("jdbc:h2:mem:test", "user", "password");
	    }
	    
	    @Test
	    public void givenMyConnectionPoolInstance_whenCalledgetConnection_thenCorrect() throws Exception {
	        assertTrue(connectionPool.getConnection().isValid(1));
	    }
	    
	    @Test
	    public void givenMyConnectionPoolInstance_whenCalledreleaseConnection_thenCorrect() throws Exception {
	        Connection connection = connectionPool.getConnection();
	        assertThat(connectionPool.releaseConnection(connection)).isTrue();
	    }
	    
	    @Test
	    public void givenMyConnectionPoolInstance_whenCalledgetUrl_thenCorrect() {
	        assertThat(connectionPool.getUrl()).isEqualTo("jdbc:h2:mem:test");
	    }
	    
	    @Test
	    public void givenMyConnectionPoolInstance_whenCalledgetUser_thenCorrect() {
	        assertThat(connectionPool.getUser()).isEqualTo("user");
	    }
	    
	    @Test
	    public void givenMyConnectionPoolInstance_whenCalledgetPassword_thenCorrect() {
	        assertThat(connectionPool.getPassword()).isEqualTo("password");
	    }

	    @Test(expected = RuntimeException.class)
	    public void givenMyConnectionPoolInstance_whenAskedForMoreThanMax_thenError() throws Exception {
	        // this test needs to be independent so it doesn't share the same connection pool as other tests
	        MyConnectionPool cp = MyConnectionPool.create("jdbc:h2:mem:test", "user", "password");
	        final int MAX_POOL_SIZE = 20;
	        for (int i = 0; i < MAX_POOL_SIZE + 1; i++) {
	            cp.getConnection();
	        }
	        fail();
	    }

	    @Test
	    public void givenMyConnectionPoolInstance_whenSutdown_thenEmpty() throws Exception {
	        IConnectionPool cp = MyConnectionPool.create("jdbc:h2:mem:test", "user", "password");
	        assertThat(((MyConnectionPool)cp).getSize()).isEqualTo(10);

	        ((MyConnectionPool) cp).shutdown();
	        assertThat(((MyConnectionPool)cp).getSize()).isEqualTo(0);
	    }
	}
