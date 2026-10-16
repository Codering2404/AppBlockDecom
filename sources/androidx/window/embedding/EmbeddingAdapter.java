package androidx.window.embedding;

import android.os.Binder;
import android.os.IBinder;
import androidx.window.WindowSdkExtensions;
import androidx.window.embedding.SplitAttributes;
import androidx.window.extensions.embedding.SplitAttributes;
import java.util.ArrayList;
import java.util.Iterator;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class EmbeddingAdapter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f54181c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Binder f54182d = new Binder();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Binder f54183e = new Binder();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VendorApiLevel1Impl f54184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final VendorApiLevel2Impl f54185b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Binder a() {
            return EmbeddingAdapter.f54182d;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class VendorApiLevel1Impl {
        public final SplitAttributes a(androidx.window.extensions.embedding.SplitInfo splitInfo) {
            Intrinsics.checkNotNullParameter(splitInfo, "splitInfo");
            return new SplitAttributes.Builder().c(SplitAttributes.SplitType.f54255c.a(splitInfo.getSplitRatio())).b(SplitAttributes.LayoutDirection.f54248d).a();
        }

        public final SplitInfo b(androidx.window.extensions.embedding.SplitInfo splitInfo) {
            Intrinsics.checkNotNullParameter(splitInfo, "splitInfo");
            List activities = splitInfo.getPrimaryActivityStack().getActivities();
            Intrinsics.checkNotNullExpressionValue(activities, "splitInfo.primaryActivityStack.activities");
            ActivityStack activityStack = new ActivityStack(activities, splitInfo.getPrimaryActivityStack().isEmpty());
            List activities2 = splitInfo.getSecondaryActivityStack().getActivities();
            Intrinsics.checkNotNullExpressionValue(activities2, "splitInfo.secondaryActivityStack.activities");
            return new SplitInfo(activityStack, new ActivityStack(activities2, splitInfo.getSecondaryActivityStack().isEmpty()), a(splitInfo), EmbeddingAdapter.f54181c.a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class VendorApiLevel2Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ EmbeddingAdapter f54192a;

        public final SplitInfo a(androidx.window.extensions.embedding.SplitInfo splitInfo) {
            Intrinsics.checkNotNullParameter(splitInfo, "splitInfo");
            androidx.window.extensions.embedding.ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
            Intrinsics.checkNotNullExpressionValue(primaryActivityStack, "splitInfo.primaryActivityStack");
            List activities = primaryActivityStack.getActivities();
            Intrinsics.checkNotNullExpressionValue(activities, "primaryActivityStack.activities");
            ActivityStack activityStack = new ActivityStack(activities, primaryActivityStack.isEmpty());
            androidx.window.extensions.embedding.ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
            Intrinsics.checkNotNullExpressionValue(secondaryActivityStack, "splitInfo.secondaryActivityStack");
            List activities2 = secondaryActivityStack.getActivities();
            Intrinsics.checkNotNullExpressionValue(activities2, "secondaryActivityStack.activities");
            ActivityStack activityStack2 = new ActivityStack(activities2, secondaryActivityStack.isEmpty());
            EmbeddingAdapter embeddingAdapter = this.f54192a;
            androidx.window.extensions.embedding.SplitAttributes splitAttributes = splitInfo.getSplitAttributes();
            Intrinsics.checkNotNullExpressionValue(splitAttributes, "splitInfo.splitAttributes");
            return new SplitInfo(activityStack, activityStack2, embeddingAdapter.e(splitAttributes), EmbeddingAdapter.f54181c.a());
        }
    }

    private final int b() {
        return WindowSdkExtensions.f54022b.a().b();
    }

    private final SplitInfo c(androidx.window.extensions.embedding.SplitInfo splitInfo) {
        int iB = b();
        if (iB == 1) {
            return this.f54184a.b(splitInfo);
        }
        if (iB == 2) {
            return this.f54185b.a(splitInfo);
        }
        androidx.window.extensions.embedding.ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
        Intrinsics.checkNotNullExpressionValue(primaryActivityStack, "splitInfo.primaryActivityStack");
        androidx.window.extensions.embedding.ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
        Intrinsics.checkNotNullExpressionValue(secondaryActivityStack, "splitInfo.secondaryActivityStack");
        List activities = primaryActivityStack.getActivities();
        Intrinsics.checkNotNullExpressionValue(activities, "primaryActivityStack.activities");
        ActivityStack activityStack = new ActivityStack(activities, primaryActivityStack.isEmpty());
        List activities2 = secondaryActivityStack.getActivities();
        Intrinsics.checkNotNullExpressionValue(activities2, "secondaryActivityStack.activities");
        ActivityStack activityStack2 = new ActivityStack(activities2, secondaryActivityStack.isEmpty());
        androidx.window.extensions.embedding.SplitAttributes splitAttributes = splitInfo.getSplitAttributes();
        Intrinsics.checkNotNullExpressionValue(splitAttributes, "splitInfo.splitAttributes");
        SplitAttributes splitAttributesE = e(splitAttributes);
        IBinder token = splitInfo.getToken();
        Intrinsics.checkNotNullExpressionValue(token, "splitInfo.token");
        return new SplitInfo(activityStack, activityStack2, splitAttributesE, token);
    }

    public final List d(List splitInfoList) {
        Intrinsics.checkNotNullParameter(splitInfoList, "splitInfoList");
        List list = splitInfoList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(c((androidx.window.extensions.embedding.SplitInfo) it.next()));
        }
        return arrayList;
    }

    public final SplitAttributes e(androidx.window.extensions.embedding.SplitAttributes splitAttributes) {
        SplitAttributes.SplitType splitTypeB;
        SplitAttributes.LayoutDirection layoutDirection;
        Intrinsics.checkNotNullParameter(splitAttributes, "splitAttributes");
        SplitAttributes.Builder builder = new SplitAttributes.Builder();
        SplitAttributes.SplitType.RatioSplitType splitType = splitAttributes.getSplitType();
        Intrinsics.checkNotNullExpressionValue(splitType, "splitAttributes.splitType");
        if (splitType instanceof SplitAttributes.SplitType.HingeSplitType) {
            splitTypeB = SplitAttributes.SplitType.f54258f;
        } else if (splitType instanceof SplitAttributes.SplitType.ExpandContainersSplitType) {
            splitTypeB = SplitAttributes.SplitType.f54256d;
        } else {
            if (!(splitType instanceof SplitAttributes.SplitType.RatioSplitType)) {
                throw new IllegalArgumentException("Unknown split type: " + splitType);
            }
            splitTypeB = SplitAttributes.SplitType.f54255c.b(splitType.getRatio());
        }
        SplitAttributes.Builder builderC = builder.c(splitTypeB);
        int layoutDirection2 = splitAttributes.getLayoutDirection();
        if (layoutDirection2 == 0) {
            layoutDirection = SplitAttributes.LayoutDirection.f54249e;
        } else if (layoutDirection2 == 1) {
            layoutDirection = SplitAttributes.LayoutDirection.f54250f;
        } else if (layoutDirection2 == 3) {
            layoutDirection = SplitAttributes.LayoutDirection.f54248d;
        } else if (layoutDirection2 == 4) {
            layoutDirection = SplitAttributes.LayoutDirection.f54251g;
        } else {
            if (layoutDirection2 != 5) {
                throw new IllegalArgumentException("Unknown layout direction: " + layoutDirection2);
            }
            layoutDirection = SplitAttributes.LayoutDirection.f54252h;
        }
        return builderC.b(layoutDirection).a();
    }
}
