package com.netflixclone.network.services

import com.netflixclone.data_models.Movie
import com.netflixclone.data_models.TvShow
import com.netflixclone.network.models.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbService {
    @GET("movie/upcoming")
    suspend fun fetchUpcomingMovies(@Query("page") page: Int): PageResponse<Movie>

    @GET("movie/popular")
    suspend fun fetchPopularMovies(@Query("page") page: Int): PageResponse<Movie>

    @GET("movie/{id}?append_to_response=similar,videos")
    suspend fun fetchMovieDetails(@Path("id") movieId: Int): MovieDetailsResponse

    @GET("movie/{id}/similar")
    suspend fun fetchSimilarMovies(@Path("id") movieId: Int): PageResponse<Movie>

    @GET("movie/{id}/videos")
    suspend fun fetchMovieVideos(@Path("id") movieId: Int): VideosResponse

    @GET("tv/popular")
    suspend fun fetchPopularTvShows(@Query("page") page: Int): PageResponse<TvShow>

    @GET("tv/top_rated")
    suspend fun fetchTopRatedTvs(): PageResponse<TvShow>

    @GET("tv/{id}?append_to_response=similar,videos")
    suspend fun fetchTvDetails(@Path("id") tvId: Int): TvDetailsResponse

    @GET("tv/{id}/similar")
    suspend fun fetchSimilarTvs(@Path("id") tvId: Int): PageResponse<TvShow>

    @GET("tv/{id}/videos")
    suspend fun fetchTvVideos(@Path("id") tvId: Int): VideosResponse

    @GET("tv/{tv_id}/season/{season_number}")
    suspend fun fetchTvSeasonDetails(
        @Path("tv_id") tvId: Int,
        @Path("season_number") seasonNumber: Int
    ): TvSeasonDetailsResponse

    @GET("search/multi")
    suspend fun fetchSearchResults(
        @Query("query") query: String,
        @Query("page") page: Int
    ): MediaResponse
}