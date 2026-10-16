package cz.mobilesoft.coreblock.rest;

import com.applovin.sdk.AppLovinEventParameters;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityArgsKt;
import cz.mobilesoft.coreblock.dto.AccountabilityPartnerCheckDTO;
import cz.mobilesoft.coreblock.dto.AdultContentPagesResponse;
import cz.mobilesoft.coreblock.dto.AppCategoriesResponse;
import cz.mobilesoft.coreblock.dto.AppPackages;
import cz.mobilesoft.coreblock.dto.HaFQuestionResponse;
import cz.mobilesoft.coreblock.dto.HaFResponse;
import cz.mobilesoft.coreblock.dto.SearchedQuestionsDTO;
import cz.mobilesoft.coreblock.rest.request.AccountabilityPartnerDeactivationRequest;
import cz.mobilesoft.coreblock.rest.request.AccountabilityPartnerRequest;
import cz.mobilesoft.coreblock.rest.request.ActivateTrialRequest;
import cz.mobilesoft.coreblock.rest.request.DeleteUserRequest;
import cz.mobilesoft.coreblock.rest.request.EmailConsentRequest;
import cz.mobilesoft.coreblock.rest.request.EmailRequest;
import cz.mobilesoft.coreblock.rest.request.IntroQuestionRequest;
import cz.mobilesoft.coreblock.rest.request.LessonStateRequest;
import cz.mobilesoft.coreblock.rest.request.LoginRequest;
import cz.mobilesoft.coreblock.rest.request.RegisterDeviceRequest;
import cz.mobilesoft.coreblock.rest.request.RegisterRequest;
import cz.mobilesoft.coreblock.rest.request.ResetPasswordRequest;
import cz.mobilesoft.coreblock.rest.request.SocialLoginRequest;
import cz.mobilesoft.coreblock.rest.request.StreakSnapshotRequest;
import cz.mobilesoft.coreblock.rest.request.TokenRefreshRequest;
import cz.mobilesoft.coreblock.rest.request.UpdateUserDetailsRequest;
import cz.mobilesoft.coreblock.rest.request.ValidateUnlockCodeRequest;
import cz.mobilesoft.coreblock.rest.response.CampaignOfferResponse;
import cz.mobilesoft.coreblock.rest.response.CourseResponse;
import cz.mobilesoft.coreblock.rest.response.CourseStateResponse;
import cz.mobilesoft.coreblock.rest.response.CurrentCampaignResponse;
import cz.mobilesoft.coreblock.rest.response.LoginResponse;
import cz.mobilesoft.coreblock.rest.response.StreakSnapshotResponse;
import cz.mobilesoft.coreblock.rest.response.TokenResponse;
import cz.mobilesoft.coreblock.rest.response.UserDetailsResponse;
import cz.mobilesoft.coreblock.scene.more.backup.dto.BackupInfoDTO;
import cz.mobilesoft.coreblock.scene.more.backup.dto.BackupRequest;
import cz.mobilesoft.coreblock.scene.more.backup.dto.BackupResponseDTO;
import cz.mobilesoft.coreblock.util.constants.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface ApiInterface {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    @POST("api/freshdesk")
    Object A(@Body RequestBody requestBody, Continuation<? super Response<Unit>> continuation);

    @POST("api/academy/courses")
    Object B(@Body List<IntroQuestionRequest> list, Continuation<? super Response<List<CourseResponse>>> continuation);

    @POST("api/backup")
    Object C(@Body BackupRequest backupRequest, Continuation<? super Response<BackupInfoDTO>> continuation);

    @PATCH("api/security/user/email-consent")
    Object D(@Body EmailConsentRequest emailConsentRequest, Continuation<? super Response<UserDetailsResponse>> continuation);

    @POST("api/security/login/{provider}")
    Object E(@Path("provider") @Constants.LoginProvider String str, @Body SocialLoginRequest socialLoginRequest, Continuation<? super Response<LoginResponse>> continuation);

    @PUT("api/streak")
    Object F(@Body StreakSnapshotRequest streakSnapshotRequest, Continuation<? super Response<StreakSnapshotResponse>> continuation);

    @GET("api/backup/info")
    Object G(Continuation<? super Response<List<BackupInfoDTO>>> continuation);

    @GET("api/campaign-notification/{id}")
    Object H(@Path("id") long j3, Continuation<? super Response<CampaignOfferResponse>> continuation);

    @POST("api/strict-mode/accountability-partner/assign")
    Object I(@Body AccountabilityPartnerRequest accountabilityPartnerRequest, Continuation<? super Response<Unit>> continuation);

    @POST("api/security/password/change")
    Object J(@Body ResetPasswordRequest resetPasswordRequest, Continuation<? super Response<LoginResponse>> continuation);

    @POST("api/revenuecat/trial")
    Object a(@Body ActivateTrialRequest activateTrialRequest, Continuation<? super Response<Unit>> continuation);

    @GET("faq/search/?device=android")
    Object b(@Query(AppLovinEventParameters.SEARCH_QUERY) String str, Continuation<? super Response<SearchedQuestionsDTO>> continuation);

    @POST("api/security/register")
    Object c(@Body RegisterRequest registerRequest, Continuation<? super Response<LoginResponse>> continuation);

    @HTTP(hasBody = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON, method = "DELETE", path = "api/security/user")
    Object d(@Body DeleteUserRequest deleteUserRequest, Continuation<? super Response<Unit>> continuation);

    @POST("api/security/refresh")
    Call<TokenResponse> e(@Body TokenRefreshRequest tokenRefreshRequest);

    @POST("api/security/login")
    Object f(@Body LoginRequest loginRequest, Continuation<? super Response<LoginResponse>> continuation);

    @POST("api/strict-mode/validate")
    Object g(@Body ValidateUnlockCodeRequest validateUnlockCodeRequest, Continuation<? super Response<Unit>> continuation);

    @DELETE("api/backup")
    Object h(Continuation<? super Response<Unit>> continuation);

    @Headers({"Endpoint-Version: 2"})
    @PUT("api/device/register")
    Object i(@Body RegisterDeviceRequest registerDeviceRequest, Continuation<? super Response<Unit>> continuation);

    @GET("api/academy/courses/progress")
    Object j(@Query("timestamp") long j3, Continuation<? super Response<List<CourseStateResponse>>> continuation);

    @POST("api/security/reset/verify")
    Object k(@Body ResetPasswordRequest resetPasswordRequest, Continuation<? super Response<Unit>> continuation);

    @PUT("api/academy/courses/progress")
    Object l(@Body LessonStateRequest lessonStateRequest, Continuation<? super Response<List<CourseStateResponse>>> continuation);

    @GET("api/backup/{id}")
    Object m(@Path("id") long j3, Continuation<? super Response<BackupResponseDTO>> continuation);

    @POST("api/categories/apps")
    Object n(@Body AppPackages appPackages, Continuation<? super Response<AppCategoriesResponse>> continuation);

    @POST("api/strict-mode/accountability-partner/deactivation-request")
    Object o(@Body AccountabilityPartnerDeactivationRequest accountabilityPartnerDeactivationRequest, @Header("accept-language") String str, Continuation<? super Response<Unit>> continuation);

    @GET("api/streak")
    Object p(Continuation<? super Response<StreakSnapshotResponse>> continuation);

    @GET("faq/{id}")
    Object q(@Path("id") int i3, Continuation<? super Response<HaFQuestionResponse>> continuation);

    @GET("faq/?device=android")
    Object r(Continuation<? super Response<HaFResponse>> continuation);

    @GET("api/strict-mode/accountability-partner/check")
    Object s(@Query("deviceId") String str, Continuation<? super Response<AccountabilityPartnerCheckDTO>> continuation);

    @PATCH("api/security/user")
    Object t(@Body UpdateUserDetailsRequest updateUserDetailsRequest, Continuation<? super Response<UserDetailsResponse>> continuation);

    @POST("api/security/reset")
    Object u(@Body EmailRequest emailRequest, Continuation<? super Response<Unit>> continuation);

    @GET("api/xblock/whitelisted")
    Object v(@Query("page") int i3, @Query("pageSize") int i4, Continuation<? super Response<AdultContentPagesResponse>> continuation);

    @GET("api/xblock/search")
    Object w(@Query("lastUpdate") String str, @Query("page") int i3, @Query("pageSize") int i4, Continuation<? super Response<AdultContentPagesResponse>> continuation);

    @GET("api/security/user")
    Object x(Continuation<? super Response<UserDetailsResponse>> continuation);

    @GET("api/campaign-notification/active")
    Object y(Continuation<? super Response<CurrentCampaignResponse>> continuation);

    @PATCH("api/security/user")
    @Multipart
    Object z(@Part MultipartBody.Part part, @Part MultipartBody.Part part2, @Query("deletePicture") Boolean bool, Continuation<? super Response<UserDetailsResponse>> continuation);
}
