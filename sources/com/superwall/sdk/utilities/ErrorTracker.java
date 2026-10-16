package com.superwall.sdk.utilities;

import com.superwall.sdk.BuildConfig;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.analytics.internal.TrackingKt;
import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.storage.ErrorLog;
import com.superwall.sdk.storage.LocalStorage;
import com.superwall.sdk.utilities.ErrorTracking;
import java.util.ArrayList;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
public final class ErrorTracker implements ErrorTracking {
    private final LocalStorage cache;
    private final Function2<InternalSuperwallEvent.ErrorThrown, Continuation<? super Unit>, Object> track;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.superwall.sdk.utilities.ErrorTracker$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.utilities.ErrorTracker$1", f = "ErrorTracking.kt", l = {51}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<InternalSuperwallEvent.ErrorThrown, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(InternalSuperwallEvent.ErrorThrown errorThrown, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(errorThrown, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                InternalSuperwallEvent.ErrorThrown errorThrown = (InternalSuperwallEvent.ErrorThrown) this.L$0;
                Superwall companion = Superwall.Companion.getInstance();
                this.label = 1;
                if (TrackingKt.track(companion, errorThrown, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                ((Result) obj).j();
            }
            return Unit.f139807a;
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.utilities.ErrorTracker$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.utilities.ErrorTracker$2", f = "ErrorTracking.kt", l = {60}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ErrorTracking.ErrorOccurence $exists;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ErrorTracking.ErrorOccurence errorOccurence, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$exists = errorOccurence;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ErrorTracker.this.new AnonymousClass2(this.$exists, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function2 function2 = ErrorTracker.this.track;
                InternalSuperwallEvent.ErrorThrown errorThrown = new InternalSuperwallEvent.ErrorThrown(this.$exists.getMessage(), this.$exists.getStacktrace(), this.$exists.getTimestamp(), this.$exists.getType(), this.$exists.isFatal());
                this.label = 1;
                if (function2.invoke(errorThrown, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            ErrorTracker.this.cache.delete(ErrorLog.INSTANCE);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ErrorTracker(CoroutineScope scope, LocalStorage cache, Function2<? super InternalSuperwallEvent.ErrorThrown, ? super Continuation<? super Unit>, ? extends Object> track) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(track, "track");
        this.cache = cache;
        this.track = track;
        ErrorTracking.ErrorOccurence errorOccurence = (ErrorTracking.ErrorOccurence) cache.read(ErrorLog.INSTANCE);
        if (errorOccurence != null) {
            BuildersKt__Builders_commonKt.d(scope, null, null, new AnonymousClass2(errorOccurence, null), 3, null);
        }
    }

    public final boolean containsAny(String str, String... strings) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        for (String str2 : strings) {
            if (StringsKt.a0(str, str2, false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.superwall.sdk.utilities.ErrorTracker] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final String replaceNonSuperwallPackages(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        List<??> listX0 = StringsKt.x0(str);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listX0, 10));
        for (?? r12 : listX0) {
            if (!containsAny(r12, BuildConfig.LIBRARY_PACKAGE_NAME, "com.superwall.supercel", "java.lang", "net.java.dev.jna", "kotlin.", "kotlinx.", "android.os", "androidx.os", "com.android.", "com.google.", "org.threeten.", "com.revenuecat.purchases")) {
                ArrayList arrayList2 = new ArrayList(r12.length());
                for (int i3 = 0; i3 < r12.length(); i3++) {
                    char cCharAt = r12.charAt(i3);
                    arrayList2.add(Character.isLetter(cCharAt) ? "*" : Character.valueOf(cCharAt));
                }
                r12 = arrayList2;
            }
            arrayList.add(r12);
        }
        return CollectionsKt.joinToString$default(arrayList, "\n", null, null, 0, null, null, 62, null);
    }

    @Override // com.superwall.sdk.utilities.ErrorTracking
    public void trackError(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        String message = throwable.getMessage();
        if (message == null) {
            message = "";
        }
        String strReplaceNonSuperwallPackages = replaceNonSuperwallPackages(ExceptionsKt.b(throwable));
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zIsFatal = ErrorTrackingKt.isFatal(throwable);
        String simpleName = throwable.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        this.cache.write(ErrorLog.INSTANCE, new ErrorTracking.ErrorOccurence(simpleName, message, strReplaceNonSuperwallPackages, jCurrentTimeMillis, zIsFatal));
    }

    public /* synthetic */ ErrorTracker(CoroutineScope coroutineScope, LocalStorage localStorage, Function2 function2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, localStorage, (i3 & 4) != 0 ? new AnonymousClass1(null) : function2);
    }
}
