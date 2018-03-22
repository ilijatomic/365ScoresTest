package com.ikac.test.common.dagger;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Image caching module
 */
@Module
public final class ImageModule {

    @Provides
    @Singleton
    Glide provideGlide(Context context) {
        return new GlideBuilder()
                .build(context);
    }
}
