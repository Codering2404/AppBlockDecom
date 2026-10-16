package com.facebook.gamingservices;

import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class GamingContext {
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_TIMEOUT = 5;
    private static GamingContext currentContext;
    private final String contextID;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final GamingContext getCurrentGamingContext() {
            JSONObject jSONObject;
            if (!CloudGameLoginHandler.isRunningInCloud()) {
                return GamingContext.currentContext;
            }
            GraphResponse graphResponseExecuteAndWait = DaemonRequest.executeAndWait(FacebookSdk.getApplicationContext(), null, SDKMessageEnum.CONTEXT_GET_ID, 5);
            String string = (graphResponseExecuteAndWait == null || (jSONObject = graphResponseExecuteAndWait.getJSONObject()) == null) ? null : jSONObject.getString("id");
            if (string == null) {
                return null;
            }
            return new GamingContext(string);
        }

        @JvmStatic
        public final void setCurrentGamingContext(GamingContext ctx) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            if (CloudGameLoginHandler.isRunningInCloud()) {
                return;
            }
            GamingContext.currentContext = ctx;
        }

        private Companion() {
        }
    }

    public GamingContext(String contextID) {
        Intrinsics.checkNotNullParameter(contextID, "contextID");
        this.contextID = contextID;
    }

    public static /* synthetic */ GamingContext copy$default(GamingContext gamingContext, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = gamingContext.contextID;
        }
        return gamingContext.copy(str);
    }

    @JvmStatic
    public static final GamingContext getCurrentGamingContext() {
        return Companion.getCurrentGamingContext();
    }

    @JvmStatic
    public static final void setCurrentGamingContext(GamingContext gamingContext) {
        Companion.setCurrentGamingContext(gamingContext);
    }

    public final String component1() {
        return this.contextID;
    }

    public final GamingContext copy(String contextID) {
        Intrinsics.checkNotNullParameter(contextID, "contextID");
        return new GamingContext(contextID);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GamingContext) && Intrinsics.areEqual(this.contextID, ((GamingContext) obj).contextID);
    }

    public final String getContextID() {
        return this.contextID;
    }

    public int hashCode() {
        return this.contextID.hashCode();
    }

    public String toString() {
        return "GamingContext(contextID=" + this.contextID + ')';
    }
}
