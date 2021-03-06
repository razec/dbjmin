/* ******************************************************************* 	*/
/* DB2-JMIN / MULTI-JMIN (MULTI DB CLIENT)								*/
/* Copyright (C) 2007  Jose' Ricardo de Oliveira Damico					*/
/* damico@dcon.com.br													*/
/* 																		*/
/* This program is free software; you can redistribute it and/or		*/
/* modify it under the terms of the GNU General Public License			*/
/* as published by the Free Software Foundation; either version 2		*/
/* of the License, or (at your option) any later version.				*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.							*/
/* 																		*/
/* You should have received a copy of the GNU General Public License	*/
/* along with this program; if not, write to the Free Software			*/
/* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, 			*/
/* MA  02110-1301, USA.													*/
/* ******************************************************************** */

package db2jmin.pojo.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

/**
 * This class is very useful to test if db server is a reachable address
 * 
 * @author Jose Damico (damico@dcon.com.br)
 * @contributor Mario C. Ponciano a.k.a Razec (mrazec@gmail.com)
 * */

public class ReachServer {

	public ReachServer(String fhost) {
		host = fhost;
		log.AddLogLine("host: " + host);
	}

	public boolean isAlive(String port) {
		boolean ret = false;

		try {
			InetAddress address = InetAddress.getByName(host);
			ret = isPortAvailable(Integer.valueOf(port));
			log.AddLogLine("host/port conn: " + ret);

		} catch (UnknownHostException e) {
			ret = false;
			log.AddLogLine("host conn: " + e);
		} catch (IOException e) {
			ret = false;
			log.AddLogLine("host conn: " + e);
		}
		System.out.println(ret);
		return ret;
	}
	
	public static boolean isPortAvailable(int port)
	{
		try {
			ServerSocket srv = new ServerSocket(port);
			srv.close();
			srv = null;
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	private String host = null;
	private Logger log = new Logger(Constants.LOGNAME);
}
