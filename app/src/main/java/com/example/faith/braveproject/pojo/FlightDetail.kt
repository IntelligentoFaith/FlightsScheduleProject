package com.example.faith.braveproject.pojo
import com.google.gson.annotations.SerializedName




data class FlightDetail(
    @SerializedName("ScheduleResource") var scheduleResource: ScheduleResource?
)

data class ScheduleResource(
    @SerializedName("Schedule") var schedule: List<Schedule?>?,
    @SerializedName("Meta") var meta: Metas?
)

data class Metas(
    @SerializedName("@Version") var version: String?,
    @SerializedName("Link") var link: List<Links?>?
)

data class Links(
    @SerializedName("@Href") var href: String?,
    @SerializedName("@Rel") var rel: String?
)

data class Schedule(
    @SerializedName("TotalJourney") var totalJourney: TotalJourney?,
    @SerializedName("Flight") var flight: List<Flight?>?
)

data class TotalJourney(
    @SerializedName("Duration") var duration: String?
)

data class Flight(
    @SerializedName("Departure") var departure: Departure?,
    @SerializedName("Arrival") var arrival: Arrival?,
    @SerializedName("MarketingCarrier") var marketingCarrier: MarketingCarrier?,
    @SerializedName("Equipment") var equipment: Equipment?,
    @SerializedName("Details") var details: Details?
)

data class Departure(
    @SerializedName("AirportCode") var airportCode: String?,
    @SerializedName("ScheduledTimeLocal") var scheduledTimeLocal: ScheduledTimeLocal?
)

data class ScheduledTimeLocal(
    @SerializedName("DateTime") var dateTime: String?
)

data class Arrival(
    @SerializedName("AirportCode") var airportCode: String?,
    @SerializedName("ScheduledTimeLocal") var scheduledTimeLocal: ScheduledTimeLocal?,
    @SerializedName("Terminal") var terminal: Terminal?
)

data class Terminal(
    @SerializedName("Name") var name: String?
)

data class Equipment(
    @SerializedName("AircraftCode") var aircraftCode: String?
)

data class MarketingCarrier(
    @SerializedName("AirlineID") var airlineID: String?,
    @SerializedName("FlightNumber") var flightNumber: Int?
)

data class Details(
    @SerializedName("Stops") var stops: Stops?,
    @SerializedName("DaysOfOperation") var daysOfOperation: Int?,
    @SerializedName("DatePeriod") var datePeriod: DatePeriod?
)

data class DatePeriod(
    @SerializedName("Effective") var effective: String?,
    @SerializedName("Expiration") var expiration: String?
)

data class Stops(
    @SerializedName("StopQuantity") var stopQuantity: Int?
)