package inf112.skeleton.app.Screens;
/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.lwjgl.opengl.XRandR;

public class FullscreenTest implements ApplicationListener {
    SpriteBatch batch;
    Texture tex;
    boolean fullscreen = false;
    BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        tex = new Texture(Gdx.files.internal("assets/img/flag.png"));
        DisplayMode m = null;
        for (DisplayMode mode : Gdx.graphics.getDisplayModes()) {
            if (m == null) {
                m = mode;
            } else {
                if (m.width < mode.width) {
                    m = mode;
                }
            }
        }

        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        batch.getProjectionMatrix().setToOrtho2D(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getBackBufferWidth(), Gdx.graphics.getBackBufferHeight());

    }

    @Override
    public void resume() {

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(tex, Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
        font.draw(batch, "" + Gdx.graphics.getWidth() + ", " + Gdx.graphics.getHeight(), 0, 20);
        batch.end();

    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("FullscreenTest", "resized: " + width + ", " + height);
        batch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);
    }

    @Override
    public void pause() {
        Gdx.app.log("FullscreenTest", "paused");
    }

    @Override
    public void dispose() {
        Gdx.app.log("FullscreenTest", "disposed");
    }
}
