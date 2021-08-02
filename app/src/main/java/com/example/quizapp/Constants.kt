package com.example.quizapp

object Constants {

    const val USER_NAME:String = "user_name"
    const val TOTAL_QUESTIONS:String = "total_questions"
    const val CORRECT_ANSWERS:String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Brazil",
            "Argentina",
            "Jordan",
            "Cuba",
            2
        )
        val que2 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Netherlands",
            "Belgium",
            "Hungary",
            "France",
            2
        )

        val que3 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Mexico",
            "Panama",
            "Ecuador",
            "Brazil",
            4
        )
        val que4 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "Armenia",
            "Ecuador",
            "Belgium",
            1
        )
        val que5 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "New Zealand",
            "Australia",
            "Kuwait",
            "Switzerland",
            2
        )
        val que6 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Fiji",
            "Denmark",
            "Azerbaijan",
            "Kazakhstan",
            1
        )
        val que7 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Fiji",
            "Denmark",
            "India",
            "Kuwait",
            3
        )
        val que8 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "New Zealand",
            "Denmark",
            "Azerbaijan",
            "Australia",
            1
        )
        val que9 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Denmark",
            "Finland",
            "Cuba",
            "Sweden",
            1
        )
        val que10 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait",
            "Dubai",
            "Qatar",
            "Lebanon",
            1
        )
        questionList.add(que1)
        questionList.add(que2)
        questionList.add(que3)
        questionList.add(que4)
        questionList.add(que5)
        questionList.add(que6)
        questionList.add(que7)
        questionList.add(que8)
        questionList.add(que9)
        questionList.add(que10)

        return questionList
    }
}