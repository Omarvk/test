package com.ru.tgra.lab1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.BufferUtils;

import java.nio.FloatBuffer;

/**
 * Created by Omar on 16.9.2016.
 */
public class CircleGraphic {
    private static FloatBuffer vertexBuffer;
    private static int vertexPointer;
    private static int verticesPerCircle = 20;


    public  static  void create(int vertexPointer) {
        float[] array = new float[2*verticesPerCircle];
        float center_x = 5.0f;
        float center_y = 5.0f;
        float radius = 1.0f;
        int counter = 0;
        array[counter++] = center_x;
        array[counter++] = center_y;
        int outerVertex = verticesPerCircle - 1;
        for(int i = 0; i < outerVertex; i++) {
            float perc = (i / (float)(outerVertex - 1));
            float rad = perc * 2 * (float)Math.PI;

            float outer_x = center_x + radius * (float)Math.cos(rad);
            float outer_y = center_x + radius * (float)Math.sin(rad);
            array[counter++] = outer_x;
            array[counter++] = outer_y;
        }
        /*int count = 0;
        for(float i = 0.0f; i < 2*Math.PI; i += 2*Math.PI /verticesPerCircle){
            //FloatBuffer value = new FloatBuffer(2*i);
            array[count++] = (float)(Math.cos(i));
            array[count++] = (float)(Math.sin(i));
            //vertexBuffer.put(i, Math.cos(value));
            //vertexBuffer.put(i+1, Math.sin(value))
        }*/
        /*float changes = 360.0F / verticesPerCircle;
        for(int i = 0; i < verticesPerCircle; i++){
            float angle = (float)(2*Math.PI) + i * changes;
            array[i*2] = (float)(Math.cos(angle));
            array[i*2+1] = (float)(Math.sin(angle));
        }*/
        CircleGraphic.vertexPointer = vertexPointer;


        vertexBuffer = BufferUtils.newFloatBuffer(2 * verticesPerCircle);
        vertexBuffer.put(array);
        vertexBuffer.rewind();

    }
    public static void drawSolidCircle() {
        /*for(int i = 0; i < vertexBuffer.remaining(); i++){
            vertexBuffer.put(i, pos);
        }*/
        Gdx.gl.glVertexAttribPointer(vertexPointer, 2, GL20.GL_FLOAT,
                false, 0, vertexBuffer);
        Gdx.gl.glDrawArrays(GL20.GL_TRIANGLE_FAN, 0, verticesPerCircle);
    }
    public static void drawOutlineCircle() {
        Gdx.gl.glVertexAttribPointer(vertexPointer, 2, GL20.GL_FLOAT,
                false, 0, vertexBuffer);
        Gdx.gl.glDrawArrays(GL20.GL_LINE_LOOP, 0, verticesPerCircle);
    }
}
