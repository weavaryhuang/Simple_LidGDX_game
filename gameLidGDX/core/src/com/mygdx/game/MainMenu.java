package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class MainMenu implements Screen {

    public static final int Play_Button_Width = 150;
    public static final int Play_Button_Height = 80;
    public static final int Exit_Button_Width = 150;
    public static final int Exit_Button_Height = 80;
    public static final int Credit_Button_Width = 150;
    public static final int Credit_Button_Height = 80;
    public static final int Play_Button_y = 500;
    public static final int Exit_Button_y = 390;
    public static final int Credit_Button_y = 280;

    MyGdxGame game;
    Texture playButtonActive;
    Texture playButtonInactive;
    Texture ExitButtonActive;
    Texture ExitButtonInactive;
    Texture CreditButtonActive;
    Texture CreditButtonInactive;

    public MainMenu(MyGdxGame game) {
        this.game = game;

        playButtonActive = new Texture("Play_active.png");
        playButtonInactive = new Texture("Play_inactive.png");
        ExitButtonActive = new Texture("Exit_active.png");
        ExitButtonInactive = new Texture("Exit_inactive.png");
        CreditButtonActive = new Texture("Credit_active.png");
        CreditButtonInactive = new Texture("Credit_inactive.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        if (Gdx.input.getX() > (MyGdxGame.WIDTH / 2 - Play_Button_Width / 2)
                && Gdx.input.getX() < (MyGdxGame.WIDTH / 2 - Play_Button_Width / 2) + Play_Button_Width
                && MyGdxGame.HEIGHT - Gdx.input.getY() > Play_Button_y
                && MyGdxGame.HEIGHT - Gdx.input.getY() < Play_Button_y +Play_Button_Height) {
            game.batch.draw(playButtonActive, MyGdxGame.WIDTH / 2 - Play_Button_Width / 2, Play_Button_y, Play_Button_Width, Play_Button_Height);
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new GameScreen(game));
            }
        }else {
            game.batch.draw(playButtonInactive, MyGdxGame.WIDTH / 2 - Play_Button_Width / 2, Play_Button_y, Play_Button_Width, Play_Button_Height);}

        if (Gdx.input.getX() > (MyGdxGame.WIDTH / 2 - Exit_Button_Width / 2)
                && Gdx.input.getX() < (MyGdxGame.WIDTH / 2 - Exit_Button_Width / 2) + Exit_Button_Width
                && MyGdxGame.HEIGHT - Gdx.input.getY() > Exit_Button_y
                && MyGdxGame.HEIGHT - Gdx.input.getY() < Exit_Button_y +Exit_Button_Height) {
            game.batch.draw(ExitButtonActive, MyGdxGame.WIDTH / 2 - Exit_Button_Width / 2, Exit_Button_y, Exit_Button_Width, Exit_Button_Height);
            if (Gdx.input.isTouched()) {
                Gdx.app.exit();
            }

        }else {
            game.batch.draw(ExitButtonInactive, MyGdxGame.WIDTH / 2 - Exit_Button_Width / 2, Exit_Button_y, Exit_Button_Width, Exit_Button_Height);}


        if (Gdx.input.getX() > (MyGdxGame.WIDTH / 2 - Credit_Button_Width / 2)
                && Gdx.input.getX() < (MyGdxGame.WIDTH / 2 - Credit_Button_Width / 2) + Credit_Button_Width
                && MyGdxGame.HEIGHT - Gdx.input.getY() > Credit_Button_y
                && MyGdxGame.HEIGHT - Gdx.input.getY() < Credit_Button_y +Credit_Button_Height) {
            game.batch.draw(CreditButtonActive, MyGdxGame.WIDTH / 2 - Credit_Button_Width / 2, Credit_Button_y, Credit_Button_Width, Credit_Button_Height);
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new CreditScreen(game));
            }

        }else {
            game.batch.draw(CreditButtonInactive, MyGdxGame.WIDTH / 2 - Credit_Button_Width / 2, Credit_Button_y, Credit_Button_Width, Credit_Button_Height);}


        game.batch.end();
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

    }
}
