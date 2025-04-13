package id.devnzr.pokedexify.di

import android.app.Application
import android.content.Context
import id.devnzr.pokedexify.core.data.di.dataSourceModule
import id.devnzr.pokedexify.core.data.di.repositoryModule
import id.devnzr.pokedexify.core.datastore.di.dataStoreModule
import id.devnzr.pokedexify.core.domain.di.useCaseModule
import id.devnzr.pokedexify.core.network.di.networkModule
import id.devnzr.pokedexify.database.di.databaseModule
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(
            module {
                single<Context> { this@App }
            }
        )
    }

    private fun initKoin(appModule: Module) = startKoin {
        modules(
            appModule,
            databaseModule,
            dataStoreModule,
            dataSourceModule,
            networkModule,
            repositoryModule,
            useCaseModule
        )
    }
}