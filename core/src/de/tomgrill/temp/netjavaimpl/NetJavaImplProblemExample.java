package de.tomgrill.temp.netjavaimpl;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Pools;

public class NetJavaImplProblemExample extends ApplicationAdapter {


    @Override
    public void create() {


        Net.HttpRequest request = Pools.get(Net.HttpRequest.class).obtain();

        request.setUrl("http://jsonplaceholder.typicode.com/posts/1");
        request.setMethod("GET");
        request.setTimeOut(2000);


        Gdx.net.sendHttpRequest(request, new Net.HttpResponseListener() {


            @Override
            public void handleHttpResponse(Net.HttpResponse httpResponse) {

                System.out.println("YEAH SUCCESSFUL RESPONSE");
                String response = httpResponse.getResultAsString();

                Json json = new Json();


                /**
                 * this will throw com.badlogic.gdx.utils.SerializationException since the response cannot be used to build SomeUselessClass object.
                 *
                 * Very easy to oversee since the exception is unchecked, BUT caught after.
                 */
                SomeUselessClass suc = json.fromJson(SomeUselessClass.class, response);


                /**
                 * uncomment what happens when you catch the exception.
                 */
//                try {
//                    SomeUselessClass suc = json.fromJson(SomeUselessClass.class, response);
//                } catch (Exception e) {
//                    System.out.println(e);
//                }


            }

            @Override
            public void failed(Throwable t) {
                System.out.println("OH NO! Successful but still failing. I can do both. Why?");
            }

            @Override
            public void cancelled() {

            }
        });


    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
