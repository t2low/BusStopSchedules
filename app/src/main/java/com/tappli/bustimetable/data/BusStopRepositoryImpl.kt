package com.tappli.bustimetable.data

import com.tappli.bustimetable.domain.BusStop
import com.tappli.bustimetable.domain.BusStopId
import java.lang.IllegalArgumentException

class BusStopRepositoryImpl {
    private val BusStops = listOf(
        BusStop(BusStopId(1), "東村山駅東口"),
        BusStop(BusStopId(2), "桜並木"),
        BusStop(BusStopId(3), "本町二丁目"),
        BusStop(BusStopId(4), "東村山税務署"),
        BusStop(BusStopId(5), "東村山市役所"),
        BusStop(BusStopId(6), "東村山市役所入口"),
        BusStop(BusStopId(7), "むさしのアイタウン中央"),
        BusStop(BusStopId(8), "本町三丁目"),
        BusStop(BusStopId(9), "鷹の道中央"),
        BusStop(BusStopId(10), "都立東村山高校"),
        BusStop(BusStopId(11), "スポーツセンター"),
        BusStop(BusStopId(12), "恩多町四丁目"),
        BusStop(BusStopId(13), "鷹の道入口"),
        BusStop(BusStopId(14), "青葉商店街北"),
        BusStop(BusStopId(15), "青葉商店街中央"),
        BusStop(BusStopId(16), "青葉商店街南"),
        BusStop(BusStopId(17), "多摩北部医療センター"),
        BusStop(BusStopId(18), "医療センター入口"),
        BusStop(BusStopId(19), "青葉通り"),
        BusStop(BusStopId(20), "青葉小学校"),
        BusStop(BusStopId(21), "青葉町住宅"),
        BusStop(BusStopId(22), "久米川町一丁目"),
        BusStop(BusStopId(23), "所沢街道入口"),
        BusStop(BusStopId(24), "秋津文化センター"),
        BusStop(BusStopId(25), "秋津小学校"),
        BusStop(BusStopId(26), "中通り中央"),
        BusStop(BusStopId(27), "秋津中通り"),
        BusStop(BusStopId(28), "新秋津駅")
    )

    fun getAll(): List<BusStop> = BusStops

    fun get(id: Int): BusStop {
        return BusStops.find { id == it.id.value } ?: throw IllegalArgumentException()
    }
}