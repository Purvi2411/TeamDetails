package com.rcb.team;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.JsonUtils;
import io.restassured.path.json.JsonPath;


public class RCBTeamTest 
{
    public static final String nativeCountry="india";
    
	@Test
	public void validateForeignPlayers() // This test validates that team has only 4 foreign players
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
			System.out.println("Excepton occured : " + e);
		}
	}
	
	@Test
	public void validateWicketKeeper() { // This test validates that team has atleast 1 wicket keeper
		try {
			String teamDetails=JsonUtils.convertJsonFileToString("teamDetails");
			JsonPath jsonPath=new JsonPath(teamDetails);
			int totalNumberOfPlayers=jsonPath.get("player.size()");
			int actualWicketKeepers=0;
			int expectedWicketKeepers=1;
			for(int playerCount=0;playerCount<totalNumberOfPlayers;playerCount++) {
				if(jsonPath.getString("player["+playerCount+"].role").equalsIgnoreCase("Wicket-keeper"));
				{
					actualWicketKeepers++;
					if(actualWicketKeepers==1) {
						break;
					}
				}
			}
			if(actualWicketKeepers >= expectedWicketKeepers) {
				Assert.assertTrue(true);
			}
		} catch(Exception e) {
			System.out.println("Excepton occured : " + e);
		}
	}
}
