package androidx.credentials.provider;

import android.app.PendingIntent;
import android.app.slice.Slice;
import android.app.slice.SliceItem;
import android.app.slice.SliceSpec;
import android.net.Uri;
import android.util.Log;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class AuthenticationAction {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f35230c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharSequence f35231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PendingIntent f35232b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api34Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api34Impl f35233a = new Api34Impl();

        private Api34Impl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AuthenticationAction a(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            List<SliceItem> items = slice.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "slice.items");
            CharSequence text = null;
            PendingIntent action = null;
            for (SliceItem sliceItem : items) {
                if (sliceItem.hasHint("androidx.credentials.provider.authenticationAction.SLICE_HINT_PENDING_INTENT")) {
                    action = sliceItem.getAction();
                } else if (sliceItem.hasHint("androidx.credentials.provider.authenticationAction.SLICE_HINT_TITLE")) {
                    text = sliceItem.getText();
                }
            }
            try {
                Intrinsics.checkNotNull(text);
                Intrinsics.checkNotNull(action);
                return new AuthenticationAction(text, action);
            } catch (Exception e3) {
                Log.i("AuthenticationAction", "fromSlice failed with: " + e3.getMessage());
                return null;
            }
        }

        public final Slice b(AuthenticationAction authenticationAction) {
            Intrinsics.checkNotNullParameter(authenticationAction, "authenticationAction");
            CharSequence charSequenceB = authenticationAction.b();
            PendingIntent pendingIntentA = authenticationAction.a();
            Slice.Builder builder = new Slice.Builder(Uri.EMPTY, new SliceSpec("AuthenticationAction", 0));
            builder.addAction(pendingIntentA, new Slice.Builder(builder).addHints(Collections.singletonList("androidx.credentials.provider.authenticationAction.SLICE_HINT_PENDING_INTENT")).build(), null).addText(charSequenceB, null, CollectionsKt.listOf("androidx.credentials.provider.authenticationAction.SLICE_HINT_TITLE"));
            Slice sliceBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(sliceBuild, "sliceBuilder.build()");
            return sliceBuild;
        }

        private Companion() {
        }
    }

    public AuthenticationAction(CharSequence title, PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        this.f35231a = title;
        this.f35232b = pendingIntent;
        if (title.length() <= 0) {
            throw new IllegalArgumentException("title must not be empty");
        }
    }

    public final PendingIntent a() {
        return this.f35232b;
    }

    public final CharSequence b() {
        return this.f35231a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationAction)) {
            return false;
        }
        AuthenticationAction authenticationAction = (AuthenticationAction) obj;
        return Intrinsics.areEqual(this.f35231a, authenticationAction.f35231a) && Intrinsics.areEqual(this.f35232b, authenticationAction.f35232b);
    }

    public int hashCode() {
        return (this.f35231a.hashCode() * 31) + this.f35232b.hashCode();
    }
}
