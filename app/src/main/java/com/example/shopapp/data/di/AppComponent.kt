package com.example.shopapp.data.di

import com.example.shopapp.data.repository.AuthRepository
import com.example.shopapp.data.repository.IAuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

//    @Provides
//    @Singleton
//    fun provideContext(appContext: Context): Context {
//        return appContext
//    }

    @Provides
    @Singleton
    fun provideAuthRepository(
        firebaseAuth: FirebaseAuth,
        firebaseFirestore: FirebaseFirestore
    ): IAuthRepository = AuthRepository(firebaseAuth, firebaseFirestore)

}

@InstallIn(SingletonComponent::class)
@Module
object FirebaseModule {

//    @Provides
//    @Singleton
//    fun provideFirebaseDatabaseInstance(): FirebaseDatabase{
//        return FirebaseDatabase.getInstance()
//    }

    @Provides
    @Singleton
    fun provideFireStoreInstance(): FirebaseFirestore{
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseAuthInstance(): FirebaseAuth{
        return FirebaseAuth.getInstance()
    }

//    @Singleton
//    @Provides
//    fun provideFirebaseStroageInstance(): StorageReference {
//        return FirebaseStorage.getInstance().getReference(FirebaseStorageConstants.ROOT_DIRECTORY)
//    }

}