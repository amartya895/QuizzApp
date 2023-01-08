package com.example.quizzapp

object setData {

    const val name:String = "name"
    const val score:String ="Score"
    fun getQuestion():ArrayList<QuestionData>{
        var que:ArrayList<QuestionData> = arrayListOf()

        var q1 = QuestionData(
            1,
            "How many times do Guggu tells Love you to Buggu?",
        "20",
            "30",
            "15",
            "0",
            3
        )

        var q2 = QuestionData(
            2,
            "What do Guggu Call his BF?",
                "Chuchunder",
            "Buggu",
            "Sona",
        "All of the above",
            4
        )
        var q3 =QuestionData(
            3,
            "Which Chochlate Guggu Likes?",
            "Kit-Kat",
            "Dairy-Milk",
            "5-star",
            "Munch",
            2,

        )
        var q4 = QuestionData(
            4,
            "Who Loves More Guggu or Buggu?",
            "Guggu",
            "Buggu",
            "Both",
            "All of the Above",
            2
        )
        var q5 = QuestionData(
            5,
            "How to Guggu make Buggu Happy?",
            "Kisses",
            "Hug",
            "Tight Hug and Kisses",
        "None of the above",
            3
        )
        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        return que
    }
}