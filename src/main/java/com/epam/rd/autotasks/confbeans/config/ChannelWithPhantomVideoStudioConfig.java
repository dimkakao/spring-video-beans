package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration
public class ChannelWithPhantomVideoStudioConfig {

    private final String movieName = "Cat & Curious %d";
    private int movieVersion = 1;
    private LocalDateTime creationDateTime = LocalDateTime.of(2001, 10, 18, 10, 0);

    @Bean
    public Channel channelBean() {
        Channel channel = new Channel();
        for (int i = 0; i < 8; i++) {
            channel.addVideo(videoBean());
        }
        return channel;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Video videoBean() {
        Video newMovie = new Video(String.format(movieName, movieVersion++), creationDateTime);
        creationDateTime = creationDateTime.plusYears(2);
        return newMovie;

    }
}
