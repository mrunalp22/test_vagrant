package com.testvagrant.scripts;

import com.testvagrant.pojo.Player;
import com.testvagrant.testdata.country;
import com.testvagrant.testdata.roles;
import com.testvagrant.utils.JsonUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.util.ArrayList;

public class TestRcbTeam {
    public final long VALID_OVERSEAS_PLAYER_COUNT = 4;
    public final long VALID_TEAM_WICKET_KEEPER_COUNT = 1;

    ArrayList <Player> players = new ArrayList();

    @BeforeClass
    public void readJsonFile() {
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader("src/test/resources/TeamRCB.json");

            Object obj = parser.parse(reader);

            JSONArray playerList = (JSONArray) ((JSONObject) obj).get("player");
            System.out.println(playerList);

            for (int i = 0; i < playerList.size(); i++) {
                players.add(JsonUtils.getObject(JsonUtils.getJson(playerList.get(i)), Player.class));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test()
    public void testValidateFourForeignPlayers() {

        long overseasPlayersCount =
            players.stream()
                .filter(player -> !player.getCountry().equals(country.INDIA.getCountryName())).
                count();

        Assert.assertEquals(overseasPlayersCount, VALID_OVERSEAS_PLAYER_COUNT);

    }

    @Test()
    public void testValidateOneWicketKeeperInTheTeam() {

        long wicketKeeperPlayerCount =
            players.stream()
                .filter(player -> player.getRole().equals(roles.WICKET_KEEPER.getPlayerRoleName())).
                count();

        Assert.assertEquals(wicketKeeperPlayerCount, VALID_TEAM_WICKET_KEEPER_COUNT);

    }

}
