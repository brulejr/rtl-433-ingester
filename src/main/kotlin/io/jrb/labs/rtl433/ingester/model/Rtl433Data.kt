package io.jrb.labs.rtl433.ingester.model

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "model"
)
@JsonSubTypes(
    JsonSubTypes.Type(value = AcuriteTower::class, name = AcuriteTower.MODEL),
    JsonSubTypes.Type(value = BmwGen3Tpms::class, name = BmwGen3Tpms.MODEL),
    JsonSubTypes.Type(value = CitroenTpms::class, name = CitroenTpms.MODEL),
    JsonSubTypes.Type(value = DscSecurity::class, name = DscSecurity.MODEL),
    JsonSubTypes.Type(value = FordTpms::class, name = FordTpms.MODEL),
    JsonSubTypes.Type(value = HyundaiTpms::class, name = HyundaiTpms.MODEL),
    JsonSubTypes.Type(value = LaCrosseTx141w::class, name = LaCrosseTx141w.MODEL),
    JsonSubTypes.Type(value = RegencyRemote::class, name = RegencyRemote.MODEL),
    JsonSubTypes.Type(value = RenaultTpms::class, name = RenaultTpms.MODEL),
    JsonSubTypes.Type(value = SchraderTpms::class, name = SchraderTpms.MODEL),
    JsonSubTypes.Type(value = SchraderEG53MA4Tpms::class, name = SchraderEG53MA4Tpms.MODEL)
)
interface Rtl433Data {
    val model: String
    val id: String?
    val device: Device?
}
