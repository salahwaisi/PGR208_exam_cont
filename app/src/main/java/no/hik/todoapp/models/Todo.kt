package no.hik.todoapp.models

import kotlinx.serialization.Serializable

@Serializable
data class Todo(val id: String, val text: String, val decisionMakerResult: Enum<DecisionMakerResult>);