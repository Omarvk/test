package com.ru.tgra.lab1;

import com.badlogic.gdx.utils.BufferUtils;
import java.nio.FloatBuffer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
/**
 * Created by Omar on 16.9.2016.
 */
public class RectangleGraphic {
    private static FloatBuffer vertexBuffer;
    private static int vertexPointer;
    public  static  void create(int vertexPointer) {
        float position_x = 150.0f;
        float position_y = 150.0f;
        RectangleGraphic.vertexPointer = vertexPointer;
        float[] array = {position_x + -50.0f, position_y + 50.0f,
                position_x + -50.0f,  position_y + -50.0f,
                position_x + 50.0f, position_y + -50.0f,
                position_x + 50.0f, position_y + 50.0f};

        /*vertexBuffer.put(0, position_x - 50.0f); //x coordinate 1
        vertexBuffer.put(1, position_y +  50.0f); //y coordinate 1
        vertexBuffer.put(2, position_x - 50.0f); //x coordinate 2
        vertexBuffer.put(3, position_y + 50.0f); //y coordinate 2
        vertexBuffer.put(4, position_x + 50.0f); //x coordinate 3
        vertexBuffer.put(5, position_y - 50.0f); //y coordinate 3
        vertexBuffer.put(6, position_x + 50.0f); //x coordinate 4
        vertexBuffer.put(7, position_y + 50.0f); //y coordinate 4*/
        vertexBuffer = BufferUtils.newFloatBuffer(8);
        vertexBuffer.put(array);
        vertexBuffer.rewind();

    }
    public static void drawSolidSquare() {


        Gdx.gl.glVertexAttribPointer(vertexPointer, 2, GL20.GL_FLOAT,
                false, 0, vertexBuffer);
        Gdx.gl.glDrawArrays(GL20.GL_TRIANGLE_FAN, 0, 4);
    }
    public static void drawOutlineSquare() {
        Gdx.gl.glVertexAttribPointer(vertexPointer, 2, GL20.GL_FLOAT,
                false, 0, vertexBuffer);
        Gdx.gl.glDrawArrays(GL20.GL_LINE_LOOP, 0, 4);
    }
}

