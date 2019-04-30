package inf112.skeleton.app.Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

public class TextureLoader{
    private static HashMap<String, Texture> textureMap = new HashMap<>();
    private static HashMap<Integer, String> robotColor = new HashMap<>();

    static {
        //Grey robots
        textureMap.put("robot_north", new Texture(Gdx.files.internal("assets/img/Robot/grey/robot_north.png")));
        textureMap.put("robot_east", new Texture(Gdx.files.internal("assets/img/Robot/grey/robot_east.png")));
        textureMap.put("robot_south", new Texture(Gdx.files.internal("assets/img/Robot/grey/robot_south.png")));
        textureMap.put("robot_west", new Texture(Gdx.files.internal("assets/img/Robot/grey/robot_west.png")));

        //Blue robots
        textureMap.put("robot_north_blue", new Texture(Gdx.files.internal("assets/img/Robot/blue/robot_north_blue.png")));
        textureMap.put("robot_east_blue", new Texture(Gdx.files.internal("assets/img/Robot/blue/robot_east_blue.png")));
        textureMap.put("robot_south_blue", new Texture(Gdx.files.internal("assets/img/Robot/blue/robot_south_blue.png")));
        textureMap.put("robot_west_blue", new Texture(Gdx.files.internal("assets/img/Robot/blue/robot_west_blue.png")));

        //Green robots
        textureMap.put("robot_north_green", new Texture(Gdx.files.internal("assets/img/Robot/green/robot_north_green.png")));
        textureMap.put("robot_east_green", new Texture(Gdx.files.internal("assets/img/Robot/green/robot_east_green.png")));
        textureMap.put("robot_south_green", new Texture(Gdx.files.internal("assets/img/Robot/green/robot_south_green.png")));
        textureMap.put("robot_west_green", new Texture(Gdx.files.internal("assets/img/Robot/green/robot_west_green.png")));

        //Mint robots
        textureMap.put("robot_north_mint", new Texture(Gdx.files.internal("assets/img/Robot/mint/robot_north_mint.png")));
        textureMap.put("robot_east_mint", new Texture(Gdx.files.internal("assets/img/Robot/mint/robot_east_mint.png")));
        textureMap.put("robot_south_mint", new Texture(Gdx.files.internal("assets/img/Robot/mint/robot_south_mint.png")));
        textureMap.put("robot_west_mint", new Texture(Gdx.files.internal("assets/img/Robot/mint/robot_west_mint.png")));

        //Pink robots
        textureMap.put("robot_north_pink", new Texture(Gdx.files.internal("assets/img/Robot/pink/robot_north_pink.png")));
        textureMap.put("robot_east_pink", new Texture(Gdx.files.internal("assets/img/Robot/pink/robot_east_pink.png")));
        textureMap.put("robot_south_pink", new Texture(Gdx.files.internal("assets/img/Robot/pink/robot_south_pink.png")));
        textureMap.put("robot_west_pink", new Texture(Gdx.files.internal("assets/img/Robot/pink/robot_west_pink.png")));

        //Purple robots
        textureMap.put("robot_north_purple", new Texture(Gdx.files.internal("assets/img/Robot/purple/robot_north_purple.png")));
        textureMap.put("robot_east_purple", new Texture(Gdx.files.internal("assets/img/Robot/purple/robot_east_purple.png")));
        textureMap.put("robot_south_purple", new Texture(Gdx.files.internal("assets/img/Robot/purple/robot_south_purple.png")));
        textureMap.put("robot_west_purple", new Texture(Gdx.files.internal("assets/img/Robot/purple/robot_west_purple.png")));

        //Red robots
        textureMap.put("robot_north_red", new Texture(Gdx.files.internal("assets/img/Robot/red/robot_north_red.png")));
        textureMap.put("robot_east_red", new Texture(Gdx.files.internal("assets/img/Robot/red/robot_east_red.png")));
        textureMap.put("robot_south_red", new Texture(Gdx.files.internal("assets/img/Robot/red/robot_south_red.png")));
        textureMap.put("robot_west_red", new Texture(Gdx.files.internal("assets/img/Robot/red/robot_west_red.png")));

        //Yellow robots
        textureMap.put("robot_north_yellow", new Texture(Gdx.files.internal("assets/img/Robot/yellow/robot_north_yellow.png")));
        textureMap.put("robot_east_yellow", new Texture(Gdx.files.internal("assets/img/Robot/yellow/robot_east_yellow.png")));
        textureMap.put("robot_south_yellow", new Texture(Gdx.files.internal("assets/img/Robot/yellow/robot_south_yellow.png")));
        textureMap.put("robot_west_yellow", new Texture(Gdx.files.internal("assets/img/Robot/yellow/robot_west_yellow.png")));

        textureMap.put("card", new Texture(Gdx.files.internal("assets/img/card.png")));
        textureMap.put("MoveForward", new Texture(Gdx.files.internal("assets/img/CardIcons/Forward.png")));
        textureMap.put("MoveBackwards", new Texture(Gdx.files.internal("assets/img/CardIcons/Backwards.png")));
        textureMap.put("RotationCardTURN_CLOCKWISE", new Texture(Gdx.files.internal("assets/img/CardIcons/Turn_ClockWise.png")));
        textureMap.put("RotationCardTURN_COUNTER_CLOCKWISE", new Texture(Gdx.files.internal("assets/img/CardIcons/Turn_Counter_Clockwise.png")));
        textureMap.put("RotationCardTURN_AROUND", new Texture(Gdx.files.internal("assets/img/CardIcons/Turn_Around.png")));
        textureMap.put("Blank card", new Texture(Gdx.files.internal("assets/img/CardIcons/Blank.png")));

        textureMap.put("sheet", new Texture(Gdx.files.internal("assets/img/sheet.png")));

        textureMap.put("lifeon", new Texture(Gdx.files.internal("assets/img/lifeon.png")));
        textureMap.put("lifeoff", new Texture(Gdx.files.internal("assets/img/lifeoff.png")));

        textureMap.put("damageoff", new Texture(Gdx.files.internal("assets/img/damageoff.png")));
        textureMap.put("damageon", new Texture(Gdx.files.internal("assets/img/damageon.png")));
        textureMap.put("damagered", new Texture(Gdx.files.internal("assets/img/damagered.png")));

        textureMap.put("powerdownon", new Texture(Gdx.files.internal("assets/img/powerdownon.png")));
        textureMap.put("powerdownoff", new Texture(Gdx.files.internal("assets/img/powerdownoff.png")));
    }

    static {
        robotColor.put(1, "_purple");
        robotColor.put(2, "_blue");
        robotColor.put(3, "_green");
        robotColor.put(4, "_yellow");
        robotColor.put(5, "_pink");
        robotColor.put(6, "");
        robotColor.put(7, "_red");
        robotColor.put(8, "_mint");
    }

    public static HashMap<String,Texture> getTextures(){ return textureMap; }
    public static String getRobotColor(int playerNumber){ return robotColor.get(playerNumber); }
}

