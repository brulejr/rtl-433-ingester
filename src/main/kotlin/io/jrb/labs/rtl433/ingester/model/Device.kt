package io.jrb.labs.rtl433.ingester.model

data class Device(
    var name: String?,
    var type: String,
    var area: String?
) {
    companion object {
        val UNKNOWN_DEVICE = Device(type = "UNKNOWN", name = null, area = null)
    }
}
