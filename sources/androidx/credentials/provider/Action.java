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
public final class Action {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f35225d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharSequence f35226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PendingIntent f35227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CharSequence f35228c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api34Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api34Impl f35229a = new Api34Impl();

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

        public final Action a(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            List<SliceItem> items = slice.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "slice.items");
            CharSequence text = "";
            PendingIntent action = null;
            CharSequence text2 = null;
            for (SliceItem sliceItem : items) {
                if (sliceItem.hasHint("androidx.credentials.provider.action.HINT_ACTION_TITLE")) {
                    text = sliceItem.getText();
                    Intrinsics.checkNotNullExpressionValue(text, "it.text");
                } else if (sliceItem.hasHint("androidx.credentials.provider.action.HINT_ACTION_SUBTEXT")) {
                    text2 = sliceItem.getText();
                } else if (sliceItem.hasHint("androidx.credentials.provider.action.SLICE_HINT_PENDING_INTENT")) {
                    action = sliceItem.getAction();
                }
            }
            try {
                Intrinsics.checkNotNull(action);
                return new Action(text, action, text2);
            } catch (Exception e3) {
                Log.i("Action", "fromSlice failed with: " + e3.getMessage());
                return null;
            }
        }

        public final Slice b(Action action) {
            Intrinsics.checkNotNullParameter(action, "action");
            CharSequence charSequenceC = action.c();
            CharSequence charSequenceB = action.b();
            PendingIntent pendingIntentA = action.a();
            Slice.Builder builderAddText = new Slice.Builder(Uri.EMPTY, new SliceSpec("Action", 0)).addText(charSequenceC, null, CollectionsKt.listOf("androidx.credentials.provider.action.HINT_ACTION_TITLE")).addText(charSequenceB, null, CollectionsKt.listOf("androidx.credentials.provider.action.HINT_ACTION_SUBTEXT"));
            builderAddText.addAction(pendingIntentA, new Slice.Builder(builderAddText).addHints(Collections.singletonList("androidx.credentials.provider.action.SLICE_HINT_PENDING_INTENT")).build(), null);
            Slice sliceBuild = builderAddText.build();
            Intrinsics.checkNotNullExpressionValue(sliceBuild, "sliceBuilder.build()");
            return sliceBuild;
        }

        private Companion() {
        }
    }

    public Action(CharSequence title, PendingIntent pendingIntent, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        this.f35226a = title;
        this.f35227b = pendingIntent;
        this.f35228c = charSequence;
        if (title.length() <= 0) {
            throw new IllegalArgumentException("title must not be empty");
        }
    }

    public final PendingIntent a() {
        return this.f35227b;
    }

    public final CharSequence b() {
        return this.f35228c;
    }

    public final CharSequence c() {
        return this.f35226a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Action)) {
            return false;
        }
        Action action = (Action) obj;
        return Intrinsics.areEqual(this.f35226a, action.f35226a) && Intrinsics.areEqual(this.f35227b, action.f35227b) && Intrinsics.areEqual(this.f35228c, action.f35228c);
    }

    public int hashCode() {
        int iHashCode = ((this.f35226a.hashCode() * 31) + this.f35227b.hashCode()) * 31;
        CharSequence charSequence = this.f35228c;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }
}
