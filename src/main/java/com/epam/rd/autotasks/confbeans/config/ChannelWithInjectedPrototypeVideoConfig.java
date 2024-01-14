package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Configuration
public class ChannelWithInjectedPrototypeVideoConfig {

    private final String movieName = "Cat Failure Compilation";
    private LocalDateTime localDateTime = LocalDateTime.of(2001, 10, 18, 10, 0);

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Video newVideo() {
        Video newMovie = new Video(movieName, localDateTime);
        localDateTime = localDateTime.plusDays(1);
        return newMovie;

    }

    @Component
    public class ChannelWithInjectedPrototypeVideo extends Channel {

        @Override
        public Stream<Video> videos() {
            return Stream.generate(ChannelWithInjectedPrototypeVideoConfig.this::newVideo);
        }
    }
}
