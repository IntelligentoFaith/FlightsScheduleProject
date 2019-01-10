package com.example.faith.braveproject.pojo

import com.google.gson.annotations.SerializedName



data class MyModelClass(
    @SerializedName("AirportResource") var airportResource: AirportResource?
)

data class AirportResource(
    @SerializedName("Airports") var airports: Airports?,
    @SerializedName("Meta") var meta: Meta?
)

data class Airports(
    @SerializedName("Airport") var airport: List<Airport?>?
)

data class Airport(
    @SerializedName("AirportCode") var airportCode: String?,
    @SerializedName("Position") var position: Position?,
    @SerializedName("CityCode") var cityCode: String?,
    @SerializedName("CountryCode") var countryCode: String?,
    @SerializedName("LocationType") var locationType: String?,
    @SerializedName("Names") var names: Names?,
    @SerializedName("UtcOffset") var utcOffset: String?,
    @SerializedName("TimeZoneId") var timeZoneId: String?
)

data class Names(
    @SerializedName("Name") var name: Name?
)

data class Name(
    @SerializedName("@LanguageCode") var languageCode: String?,
    @SerializedName("port") var port: String?
)

data class Position(
    @SerializedName("Coordinate") var coordinate: Coordinate?
)

data class Coordinate(
    @SerializedName("Latitude") var latitude: Double?,
    @SerializedName("Longitude") var longitude: Double?
)

data class Meta(
    @SerializedName("@Version") var version: String?,
    @SerializedName("Link") var link: List<Link?>?,
    @SerializedName("TotalCount") var totalCount: Int?
)

data class Link(
    @SerializedName("@Href") var href: String?,
    @SerializedName("@Rel") var rel: String?
)