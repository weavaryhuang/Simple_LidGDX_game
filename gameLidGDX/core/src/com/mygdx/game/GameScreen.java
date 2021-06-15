package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen {

    SpriteBatch batch;
    BitmapFont font;
    Texture img;
    Sprite sprite;
    MyGdxGame game;


    public GameScreen(MyGdxGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        img = new Texture("Biker.png");
        sprite = new Sprite(img);
        sprite.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
    }

    @Override
    public void render(float delta) {


        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            sprite.translateX(-2f);
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            sprite.translateX(2f);
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            sprite.translateY(2f);
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            sprite.translateY(-2f);
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT))
            sprite.setPosition(Gdx.input.getX(),Gdx.graphics.getHeight()-Gdx.input.getY());


        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(sprite, sprite.getX(), sprite.getY());
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
