package io.jrb.labs.rtl433.ingester.model

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "model"
)
@JsonSubTypes(
    JsonSubTypes.Type(value = BmwGen3Tpms::class, name = "BMW-GEN3"),
    JsonSubTypes.Type(value = DscSecurity::class, name = "DSC-Security"),
    JsonSubTypes.Type(value = SchraderTpms::class, name = "Regency-Remote"),
    JsonSubTypes.Type(value = SchraderTpms::class, name = "Schrader-EG53MA4")
)
interface Rtl433Data {
    val model: String
    val id: String?
}
