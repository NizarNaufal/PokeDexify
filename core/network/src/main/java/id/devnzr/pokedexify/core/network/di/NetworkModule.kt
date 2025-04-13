package id.devnzr.pokedexify.core.network.di

import id.devnzr.pokedexify.core.network.BuildConfig
import id.devnzr.pokedexify.core.network.client.getHttpClient
import id.devnzr.pokedexify.core.network.ext.RetrofitClient
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {
    single(named("BaseClient")) {
        RetrofitClient.create(
            baseUrl = BuildConfig.BASE_URL, okHttpClient = getHttpClient(get())
        )
    }
}