package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import com.epam.rd.autotasks.confbeans.video.VideoStudio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class ChannelWithVideoStudioConfig {

    @Bean
    public Channel channelBean() {
        Channel channel = new Channel();
        VideoStudio videoStudio = videoStudioBean();
        for (int i = 0; i < 8; i++) {
            channel.addVideo(videoStudio.produce());
        }
        return channel;
    }

    @Bean
    public VideoStudio videoStudioBean() {

        return new VideoStudio() {

            final String movieName = "Cat & Curious %d";
            int movieVersion = 1;
            LocalDateTime creationDateTime = LocalDateTime.of(2001, 10, 18, 10, 0);

            @Override
            public Video produce() {
                Video newMovie = new Video(String.format(movieName, movieVersion++), creationDateTime);
                creationDateTime = creationDateTime.plusYears(2);
                return newMovie;
            }
        };
    }
}
