package no.hik.todoapp.models

data class DecisionMakerHttpResponseMagic(val question: String, val answer: String, val type: String)
data class DecisionMakerHttpResponse(val magic: DecisionMakerHttpResponseMagic)
