package com.rcb.team;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.JsonUtils;
import io.restassured.path.json.JsonPath;


public class RCBTeamTest 
{
    public static final String nativeCountry="india";
    
	@Test
	public void validateForeignPlayers()
	{
		try {
			String teamDetails=JsonUtils.convertJsonFileToString("teamDetails");
			JsonPath jsonPath=new JsonPath(teamDetails);
			int totalNumberOfPlayers=jsonPath.get("player.size()");
			int actualForeignPlayers=0;
			int expectedForeignPlayers=4;
			for(int playerCount=0;playerCount<totalNumberOfPlayers;playerCount++) {
				System.out.println(jsonPath.getString("player["+playerCount+"].country"));
				if(!jsonPath.getString("player["+playerCount+"].country").equalsIgnoreCase(nativeCountry));
				{
					actualForeignPlayers++;
				}
			}
			Assert.assertEquals(actualForeignPlayers, expectedForeignPlayers);
		} catch(Exception e) {

		}
	}
}
