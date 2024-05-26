package com.mya.bookdbcodetest.data

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

// Repository class acts as a single source of truth for data
@ActivityRetainedScoped
class Repository @Inject constructor(
    remoteDataSource: RemoteDataSource, // Remote data source instance
   localDataSource: LocalDataSource // Local data source instance
) {
    val remote = remoteDataSource

    val local = localDataSource
}