package org.example.twitterApp.controler.service.factory;

import org.example.twitterApp.controler.service.factory.classFactory.*;

public class ServiceFactory extends ValidateValueClass {

    public UserFactoryInterface create(String channel) {
        switch (channel) {
            case "ru":
                return new RegisterUserFactory();
            case "tu":
                return new TwitterUserFactory();
            case "post":
                return new PostFactory();
            case "follow":
                return new FollowFactory();
            default:
                throw new IllegalArgumentException("Unknown channel " + channel);
        }
    }

}
