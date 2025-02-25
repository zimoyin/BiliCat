@file:UseSerializers(OKHttpURLSerializer::class)

package ink.bluecloud.model.networkapi.api.data

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl

@Serializable
data class HttpApi(
//  Login
    val getLoginQRCode: HttpUrl,
    val getLoginStatus: HttpUrl,
//    Video
    val getPortalVideos: HttpUrl,
    val getVideoINFO: HttpUrl,
    val getVideoStreamURL: HttpUrl,
    val getVideoWeeklyList: HttpUrl,
    val getVideoWeeklyHistoryList: HttpUrl,
    val getHotVideoList: HttpUrl,
    val getFullRank: HttpUrl,
//    User
    val getAccountInfo: HttpUrl,
//    Other
    val getBili: HttpUrl,
//    Barrage
    val getRealTimeBarrage:HttpUrl,
    val getHistoricalBarret:HttpUrl,
    val getHistoricalBarretDate:HttpUrl,
    //Comment
    val getCommentAreaPageLoad: HttpUrl,
    val getCommentLazyPageLoad: HttpUrl,
    val getCommentReply: HttpUrl,
    val getCommentReplyTree: HttpUrl,
    val getCommentAreaHot: HttpUrl,
    val getCommentAreaCount: HttpUrl,
)

object OKHttpURLSerializer : KSerializer<HttpUrl> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("HttpUrlSerializer", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: HttpUrl) {
        encoder.encodeString(value.toString())
    }

    override fun deserialize(decoder: Decoder): HttpUrl {
        return decoder.decodeString().toHttpUrl()
    }
}
