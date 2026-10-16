package cz.mobilesoft.coreblock.storage.datastore;

import android.content.Context;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.MultiProcessDataStoreFactory;
import androidx.datastore.core.Serializer;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreFile;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import androidx.datastore.preferences.core.PreferencesKt;
import androidx.datastore.preferences.core.PreferencesSerializer;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import okio.Buffer;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class BaseDataStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f123998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataStore f123999b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1 implements Serializer<Preferences> {
        AnonymousClass1() {
        }

        @Override // androidx.datastore.core.Serializer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Preferences getDefaultValue() {
            return PreferencesSerializer.f35957a.getDefaultValue();
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // androidx.datastore.core.Serializer
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object writeTo(androidx.datastore.preferences.core.Preferences r9, java.io.OutputStream r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
            /*
                r8 = this;
                boolean r0 = r11 instanceof cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$1$writeTo$1
                if (r0 == 0) goto L13
                r0 = r11
                cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$1$writeTo$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$1$writeTo$1) r0
                int r1 = r0.f124005g
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f124005g = r1
                goto L18
            L13:
                cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$1$writeTo$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$1$writeTo$1
                r0.<init>(r8, r11)
            L18:
                java.lang.Object r11 = r0.f124003d
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f124005g
                r3 = 1
                if (r2 == 0) goto L3f
                if (r2 != r3) goto L37
                java.lang.Object r9 = r0.f124002c
                okio.Buffer r9 = (okio.Buffer) r9
                java.lang.Object r10 = r0.f124001b
                java.io.OutputStream r10 = (java.io.OutputStream) r10
                java.lang.Object r0 = r0.f124000a
                androidx.datastore.preferences.core.Preferences r0 = (androidx.datastore.preferences.core.Preferences) r0
                kotlin.ResultKt.b(r11)
                r2 = r9
            L35:
                r3 = r10
                goto L5e
            L37:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L3f:
                kotlin.ResultKt.b(r11)
                okio.Buffer r11 = new okio.Buffer
                r11.<init>()
                androidx.datastore.preferences.core.PreferencesSerializer r2 = androidx.datastore.preferences.core.PreferencesSerializer.f35957a
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
                r0.f124000a = r4
                r0.f124001b = r10
                r0.f124002c = r11
                r0.f124005g = r3
                java.lang.Object r9 = r2.b(r9, r11, r0)
                if (r9 != r1) goto L5c
                return r1
            L5c:
                r2 = r11
                goto L35
            L5e:
                r6 = 2
                r7 = 0
                r4 = 0
                okio.Buffer.R1(r2, r3, r4, r6, r7)
                kotlin.Unit r9 = kotlin.Unit.f139807a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore.AnonymousClass1.writeTo(androidx.datastore.preferences.core.Preferences, java.io.OutputStream, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @Override // androidx.datastore.core.Serializer
        public Object readFrom(InputStream inputStream, Continuation continuation) throws IOException {
            return PreferencesSerializer.f35957a.a(new Buffer().N(inputStream), continuation);
        }
    }

    public BaseDataStore(final Context context, final String name, List migrations, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(migrations, "migrations");
        CoroutineScope coroutineScopeA = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b()));
        this.f123998a = coroutineScopeA;
        Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BaseDataStore.g(context, name);
            }
        };
        this.f123999b = z2 ? MultiProcessDataStoreFactory.f35776a.a(new AnonymousClass1(), new ReplaceFileCorruptionHandler(new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseDataStore.h((CorruptionException) obj);
            }
        }), migrations, coroutineScopeA, function0) : PreferenceDataStoreFactory.f35946a.b(new ReplaceFileCorruptionHandler(new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseDataStore.i((CorruptionException) obj);
            }
        }), migrations, coroutineScopeA, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File g(Context context, String str) {
        return PreferenceDataStoreFile.a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Preferences h(CorruptionException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return PreferencesFactory.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Preferences i(CorruptionException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return PreferencesFactory.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow o(BaseDataStore baseDataStore, final Preferences.Key key, final Function0 function0) {
        final Flow data = baseDataStore.f123999b.getData();
        return new Flow<Object>() { // from class: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$0$$inlined$map$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$0$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f124039a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ Preferences.Key f124040b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ Function0 f124041c;

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$0$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$0$$inlined$map$1$2", f = "BaseDataStore.kt", l = {50}, m = "emit", v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f124042a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f124043b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f124044c;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    Object f124046f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    Object f124047g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    Object f124048h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    int f124049i;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f124042a = obj;
                        this.f124043b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Preferences.Key key, Function0 function0) {
                    this.f124039a = flowCollector;
                    this.f124040b = key;
                    this.f124041c = function0;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$0$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$0$$inlined$map$1$2$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$0$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f124043b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f124043b = r1
                        goto L18
                    L13:
                        cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$0$$inlined$map$1$2$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$0$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.f124042a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f124043b
                        r3 = 1
                        if (r2 == 0) goto L39
                        if (r2 != r3) goto L31
                        java.lang.Object r6 = r0.f124048h
                        kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
                        java.lang.Object r6 = r0.f124046f
                        cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$0$$inlined$map$1$2$1 r6 = (cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$0$$inlined$map$1.AnonymousClass2.AnonymousClass1) r6
                        kotlin.ResultKt.b(r7)
                        goto L73
                    L31:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L39:
                        kotlin.ResultKt.b(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.f124039a
                        r2 = r6
                        androidx.datastore.preferences.core.Preferences r2 = (androidx.datastore.preferences.core.Preferences) r2
                        androidx.datastore.preferences.core.Preferences$Key r4 = r5.f124040b
                        java.lang.Object r2 = r2.c(r4)
                        if (r2 != 0) goto L4f
                        kotlin.jvm.functions.Function0 r2 = r5.f124041c
                        java.lang.Object r2 = r2.invoke()
                    L4f:
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
                        r0.f124044c = r4
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                        r0.f124046f = r4
                        java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
                        r0.f124047g = r6
                        java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f124048h = r6
                        r6 = 0
                        r0.f124049i = r6
                        r0.f124043b = r3
                        java.lang.Object r6 = r7.emit(r2, r0)
                        if (r6 != r1) goto L73
                        return r1
                    L73:
                        kotlin.Unit r6 = kotlin.Unit.f139807a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$0$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = data.collect(new AnonymousClass2(flowCollector, key, function0), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow p(BaseDataStore baseDataStore, final Function1 function1, final Preferences.Key key, final Function0 function0) {
        final Flow data = baseDataStore.f123999b.getData();
        return new Flow<Object>() { // from class: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$1$$inlined$map$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$1$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f124054a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ Function1 f124055b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ Preferences.Key f124056c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ Function0 f124057d;

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$1$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$1$$inlined$map$1$2", f = "BaseDataStore.kt", l = {50}, m = "emit", v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f124058a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f124059b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f124060c;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    Object f124062f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    Object f124063g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    Object f124064h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    int f124065i;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f124058a = obj;
                        this.f124059b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Function1 function1, Preferences.Key key, Function0 function0) {
                    this.f124054a = flowCollector;
                    this.f124055b = function1;
                    this.f124056c = key;
                    this.f124057d = function0;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$1$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$1$$inlined$map$1$2$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$1$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f124059b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f124059b = r1
                        goto L18
                    L13:
                        cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$1$$inlined$map$1$2$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$1$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.f124058a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f124059b
                        r3 = 1
                        if (r2 == 0) goto L39
                        if (r2 != r3) goto L31
                        java.lang.Object r7 = r0.f124064h
                        kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                        java.lang.Object r7 = r0.f124062f
                        cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$1$$inlined$map$1$2$1 r7 = (cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$1$$inlined$map$1.AnonymousClass2.AnonymousClass1) r7
                        kotlin.ResultKt.b(r8)
                        goto L79
                    L31:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L39:
                        kotlin.ResultKt.b(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.f124054a
                        r2 = r7
                        androidx.datastore.preferences.core.Preferences r2 = (androidx.datastore.preferences.core.Preferences) r2
                        kotlin.jvm.functions.Function1 r4 = r6.f124055b
                        androidx.datastore.preferences.core.Preferences$Key r5 = r6.f124056c
                        java.lang.Object r2 = r2.c(r5)
                        if (r2 != 0) goto L51
                        kotlin.jvm.functions.Function0 r2 = r6.f124057d
                        java.lang.Object r2 = r2.invoke()
                    L51:
                        java.lang.Object r2 = r4.invoke(r2)
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f124060c = r4
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                        r0.f124062f = r4
                        java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f124063g = r7
                        java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
                        r0.f124064h = r7
                        r7 = 0
                        r0.f124065i = r7
                        r0.f124059b = r3
                        java.lang.Object r7 = r8.emit(r2, r0)
                        if (r7 != r1) goto L79
                        return r1
                    L79:
                        kotlin.Unit r7 = kotlin.Unit.f139807a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyFlow$lambda$1$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = data.collect(new AnonymousClass2(flowCollector, function1, key, function0), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow r(BaseDataStore baseDataStore, final Preferences.Key key) {
        final Flow data = baseDataStore.f123999b.getData();
        return new Flow<Object>() { // from class: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyNullableFlow$lambda$0$$inlined$map$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyNullableFlow$lambda$0$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f124068a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ Preferences.Key f124069b;

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyNullableFlow$lambda$0$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyNullableFlow$lambda$0$$inlined$map$1$2", f = "BaseDataStore.kt", l = {50}, m = "emit", v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f124070a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f124071b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f124072c;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    Object f124074f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    Object f124075g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    Object f124076h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    int f124077i;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f124070a = obj;
                        this.f124071b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Preferences.Key key) {
                    this.f124068a = flowCollector;
                    this.f124069b = key;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyNullableFlow$lambda$0$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyNullableFlow$lambda$0$$inlined$map$1$2$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyNullableFlow$lambda$0$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f124071b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f124071b = r1
                        goto L18
                    L13:
                        cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyNullableFlow$lambda$0$$inlined$map$1$2$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyNullableFlow$lambda$0$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.f124070a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f124071b
                        r3 = 1
                        if (r2 == 0) goto L39
                        if (r2 != r3) goto L31
                        java.lang.Object r6 = r0.f124076h
                        kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
                        java.lang.Object r6 = r0.f124074f
                        cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyNullableFlow$lambda$0$$inlined$map$1$2$1 r6 = (cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyNullableFlow$lambda$0$$inlined$map$1.AnonymousClass2.AnonymousClass1) r6
                        kotlin.ResultKt.b(r7)
                        goto L6b
                    L31:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L39:
                        kotlin.ResultKt.b(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.f124068a
                        r2 = r6
                        androidx.datastore.preferences.core.Preferences r2 = (androidx.datastore.preferences.core.Preferences) r2
                        androidx.datastore.preferences.core.Preferences$Key r4 = r5.f124069b
                        java.lang.Object r2 = r2.c(r4)
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
                        r0.f124072c = r4
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                        r0.f124074f = r4
                        java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
                        r0.f124075g = r6
                        java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f124076h = r6
                        r6 = 0
                        r0.f124077i = r6
                        r0.f124071b = r3
                        java.lang.Object r6 = r7.emit(r2, r0)
                        if (r6 != r1) goto L6b
                        return r1
                    L6b:
                        kotlin.Unit r6 = kotlin.Unit.f139807a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$lazyNullableFlow$lambda$0$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = data.collect(new AnonymousClass2(flowCollector, key), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        };
    }

    protected final Object j(final Preferences.Key key, final Function0 function0, Continuation continuation) {
        final Flow data = this.f123999b.getData();
        return FlowKt.D(new Flow<Object>() { // from class: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f124009a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ Preferences.Key f124010b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ Function0 f124011c;

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$1$2", f = "BaseDataStore.kt", l = {50}, m = "emit", v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f124012a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f124013b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f124014c;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    Object f124016f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    Object f124017g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    Object f124018h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    int f124019i;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f124012a = obj;
                        this.f124013b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Preferences.Key key, Function0 function0) {
                    this.f124009a = flowCollector;
                    this.f124010b = key;
                    this.f124011c = function0;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$1$2$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f124013b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f124013b = r1
                        goto L18
                    L13:
                        cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$1$2$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.f124012a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f124013b
                        r3 = 1
                        if (r2 == 0) goto L39
                        if (r2 != r3) goto L31
                        java.lang.Object r6 = r0.f124018h
                        kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
                        java.lang.Object r6 = r0.f124016f
                        cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$1$2$1 r6 = (cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$1.AnonymousClass2.AnonymousClass1) r6
                        kotlin.ResultKt.b(r7)
                        goto L73
                    L31:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L39:
                        kotlin.ResultKt.b(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.f124009a
                        r2 = r6
                        androidx.datastore.preferences.core.Preferences r2 = (androidx.datastore.preferences.core.Preferences) r2
                        androidx.datastore.preferences.core.Preferences$Key r4 = r5.f124010b
                        java.lang.Object r2 = r2.c(r4)
                        if (r2 != 0) goto L4f
                        kotlin.jvm.functions.Function0 r2 = r5.f124011c
                        java.lang.Object r2 = r2.invoke()
                    L4f:
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
                        r0.f124014c = r4
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                        r0.f124016f = r4
                        java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
                        r0.f124017g = r6
                        java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f124018h = r6
                        r6 = 0
                        r0.f124019i = r6
                        r0.f124013b = r3
                        java.lang.Object r6 = r7.emit(r2, r0)
                        if (r6 != r1) goto L73
                        return r1
                    L73:
                        kotlin.Unit r6 = kotlin.Unit.f139807a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation2) {
                Object objCollect = data.collect(new AnonymousClass2(flowCollector, key, function0), continuation2);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        }, continuation);
    }

    protected final Object k(final Preferences.Key key, final Function1 function1, final Function0 function0, Continuation continuation) {
        final Flow data = this.f123999b.getData();
        return FlowKt.D(new Flow<Object>() { // from class: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$2

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f124024a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ Function1 f124025b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ Preferences.Key f124026c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ Function0 f124027d;

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$2$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$2$2", f = "BaseDataStore.kt", l = {50}, m = "emit", v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f124028a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f124029b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f124030c;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    Object f124032f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    Object f124033g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    Object f124034h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    int f124035i;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f124028a = obj;
                        this.f124029b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Function1 function1, Preferences.Key key, Function0 function0) {
                    this.f124024a = flowCollector;
                    this.f124025b = function1;
                    this.f124026c = key;
                    this.f124027d = function0;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$2$2$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f124029b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f124029b = r1
                        goto L18
                    L13:
                        cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$2$2$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$2$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.f124028a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f124029b
                        r3 = 1
                        if (r2 == 0) goto L39
                        if (r2 != r3) goto L31
                        java.lang.Object r7 = r0.f124034h
                        kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                        java.lang.Object r7 = r0.f124032f
                        cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$2$2$1 r7 = (cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$2.AnonymousClass2.AnonymousClass1) r7
                        kotlin.ResultKt.b(r8)
                        goto L79
                    L31:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L39:
                        kotlin.ResultKt.b(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.f124024a
                        r2 = r7
                        androidx.datastore.preferences.core.Preferences r2 = (androidx.datastore.preferences.core.Preferences) r2
                        kotlin.jvm.functions.Function1 r4 = r6.f124025b
                        androidx.datastore.preferences.core.Preferences$Key r5 = r6.f124026c
                        java.lang.Object r2 = r2.c(r5)
                        if (r2 != 0) goto L51
                        kotlin.jvm.functions.Function0 r2 = r6.f124027d
                        java.lang.Object r2 = r2.invoke()
                    L51:
                        java.lang.Object r2 = r4.invoke(r2)
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f124030c = r4
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                        r0.f124032f = r4
                        java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f124033g = r7
                        java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
                        r0.f124034h = r7
                        r7 = 0
                        r0.f124035i = r7
                        r0.f124029b = r3
                        java.lang.Object r7 = r8.emit(r2, r0)
                        if (r7 != r1) goto L79
                        return r1
                    L79:
                        kotlin.Unit r7 = kotlin.Unit.f139807a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.BaseDataStore$get$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation2) {
                Object objCollect = data.collect(new AnonymousClass2(flowCollector, function1, key, function0), continuation2);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        }, continuation);
    }

    public final DataStore l() {
        return this.f123999b;
    }

    protected final Lazy m(final Preferences.Key key, final Function0 defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BaseDataStore.o(this.f124772a, key, defaultValue);
            }
        });
    }

    protected final Lazy n(final Preferences.Key key, final Function1 converter, final Function0 defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BaseDataStore.p(this.f124691a, converter, key, defaultValue);
            }
        });
    }

    protected final Lazy q(final Preferences.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BaseDataStore.r(this.f124770a, key);
            }
        });
    }

    protected final Object s(Preferences.Key key, Object obj, Continuation continuation) {
        Object objA = PreferencesKt.a(this.f123999b, new BaseDataStore$set$2(key, obj, null), continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    public /* synthetic */ BaseDataStore(Context context, String str, List list, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i3 & 4) != 0 ? CollectionsKt.emptyList() : list, (i3 & 8) != 0 ? false : z2);
    }
}
