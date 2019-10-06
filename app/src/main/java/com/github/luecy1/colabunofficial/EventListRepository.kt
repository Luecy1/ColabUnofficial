package com.github.luecy1.colabunofficial

import com.github.luecy1.colabunofficial.model.Event
import com.github.luecy1.colabunofficial.model.Series

class EventListRepository {

    fun getEventList(): List<Event> {

        val list = mutableListOf<Event>()

        val series =
            Series(id = 10, title = "サポーターズ勉強会", url = "https://supporterzcolab.com/series/1/")

        repeat(10) {
            val event = Event(
                eventId = 10,
                title = "今更聞けない機械学習の基礎と応用",
                catch = "最前線のデータサイエンティストに学ぶ実践型勉強会",
                description = "サポーターズが贈るエンジニア勉強会。今回のテーマは「今更聞けない機械学習の基礎と応用」。",
                eventUrl = "https://supporterzcolab.com/event/364/",
                hashTag = "supporterz",
                startedAt = "2017-03-28T19:30:00+09:00\n",
                endedAt = "2017-03-28T21:00:00+09:00",
                limit = 50,
                eventType = "participation",
                series = series,
                address = "東京都渋谷区神泉町8-16\n",
                place = "サポーターズオフィス\n",
                lat = "35.655319500000\n",
                lon = "139.693779500000",
                ownerId = "8",
                ownerNickname = "HiroakiKaede",
                ownerDisplayName = "HiroakiKaede",
                accepted = 50,
                waiting = 5,
                updatedAt = "2017-02-22T13:53:32+09:00"
            )

            list += event
        }

        return list
    }
}