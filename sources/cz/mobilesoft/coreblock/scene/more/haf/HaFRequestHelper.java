package cz.mobilesoft.coreblock.scene.more.haf;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import cz.mobilesoft.coreblock.dto.HaFQuestionResponse;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.ViewModelState;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
public final class HaFRequestHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HaFRequestHelper f107559a = new HaFRequestHelper();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f107560b = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.haf.x0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return HaFRequestHelper.m();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f107561c = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.haf.y0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return HaFRequestHelper.c();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f107562d = 8;

    private HaFRequestHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableStateFlow c() {
        return StateFlowKt.a(new HafState(null, null, null, null, null, null, null, 127, null));
    }

    public static /* synthetic */ Object g(HaFRequestHelper haFRequestHelper, Integer num, boolean z2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return haFRequestHelper.f(num, z2, continuation);
    }

    private final float h(Context context, int i3) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i3, typedValue, true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(typedValue.data, new int[]{R.attr.textSize});
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    private final MutableStateFlow j() {
        return (MutableStateFlow) f107561c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StateFlow m() {
        return FlowKt.c(f107559a.j());
    }

    public final void d() {
        j().setValue(HafState.b((HafState) j().getValue(), null, null, null, Success.f128020a, null, null, null, 87, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(kotlin.coroutines.Continuation r15) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.haf.HaFRequestHelper.e(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(java.lang.Integer r18, boolean r19, kotlin.coroutines.Continuation r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.haf.HaFRequestHelper.f(java.lang.Integer, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final StateFlow i() {
        return (StateFlow) f107560b.getValue();
    }

    public final void k() {
        j().setValue(HafState.b((HafState) j().getValue(), null, null, null, null, null, null, null, 63, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object l(java.lang.String r17, kotlin.coroutines.Continuation r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.haf.HaFRequestHelper.l(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String n(Context context, String content, String title, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(title, "title");
        return "\n        <!DOCTYPE html>\n        <html>\n        <head>\n            <meta charset=\"UTF-8\">\n            <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n            <style>\n                body {\n                    font-family: -android-system, \"Segoe UI\", \"Helvetica Neue\", sans-serif;\n                    font-size: " + h(context, cz.mobilesoft.coreblock.R.attr.f95444k) + "px;\n                    margin: 0;\n                    padding: 20px;\n                    line-height: 1.6;\n                    color: " + (z2 ? "#f0f7ff" : "#111827") + ";\n                    background-color: " + (z2 ? "black" : "#ECF1FC") + ";\n                    margin-inline: auto;\n                }\n                h1, h2, h3, h4, h5, h6 {\n                    font-weight: 500;\n                }\n                p {\n                    margin-bottom: 1em;\n                }\n                .title {\n                    font-size: 1.5rem;\n                    line-height: 1.2;\n                    margin: 0;\n                }\n                a {\n                    color: #2F96FF;\n                    text-decoration: none;\n                }\n                img {\n                    max-width: 100%;\n                    height: auto;\n                }\n        \n                iframe {\n                    width: 100% !important;\n                    height: auto;\n                    aspect-ratio: 16/9;\n                    padding: 0;\n                    margin: 0;\n                }\n                \n                video {\n                    width: 100% !important;\n                    height: auto;\n                }\n        \n                figure.wp-block-embed {\n                    width: 100% !important;\n                    height: auto;\n                    aspect-ratio: 16/9;\n                    padding: 0;\n                    margin: 0;\n                }\n        \n                .feedback-footer {\n                    margin-top: 30px;\n                    color: gray;\n                    text-align: center;\n                }\n        \n                .feedback-footer a {\n                    color: gray;\n                    text-decoration: underline;\n                    text-underline-offset: 2px\n                }\n            </style>\n        </head>\n        <body>\n            <h1 class=\"title\">" + title + "</h1>\n        \n            " + content + "\n        </body>\n        </html>\n        ";
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class HafState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f107563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map f107564b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ViewModelState f107565c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ViewModelState f107566d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final HaFQuestionResponse f107567e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final List f107568f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final HaFQuestionResponse f107569g;

        public HafState(List categories, Map topQuestions, ViewModelState state, ViewModelState searchState, HaFQuestionResponse haFQuestionResponse, List list, HaFQuestionResponse haFQuestionResponse2) {
            Intrinsics.checkNotNullParameter(categories, "categories");
            Intrinsics.checkNotNullParameter(topQuestions, "topQuestions");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(searchState, "searchState");
            this.f107563a = categories;
            this.f107564b = topQuestions;
            this.f107565c = state;
            this.f107566d = searchState;
            this.f107567e = haFQuestionResponse;
            this.f107568f = list;
            this.f107569g = haFQuestionResponse2;
        }

        public static /* synthetic */ HafState b(HafState hafState, List list, Map map, ViewModelState viewModelState, ViewModelState viewModelState2, HaFQuestionResponse haFQuestionResponse, List list2, HaFQuestionResponse haFQuestionResponse2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = hafState.f107563a;
            }
            if ((i3 & 2) != 0) {
                map = hafState.f107564b;
            }
            if ((i3 & 4) != 0) {
                viewModelState = hafState.f107565c;
            }
            if ((i3 & 8) != 0) {
                viewModelState2 = hafState.f107566d;
            }
            if ((i3 & 16) != 0) {
                haFQuestionResponse = hafState.f107567e;
            }
            if ((i3 & 32) != 0) {
                list2 = hafState.f107568f;
            }
            if ((i3 & 64) != 0) {
                haFQuestionResponse2 = hafState.f107569g;
            }
            List list3 = list2;
            HaFQuestionResponse haFQuestionResponse3 = haFQuestionResponse2;
            HaFQuestionResponse haFQuestionResponse4 = haFQuestionResponse;
            ViewModelState viewModelState3 = viewModelState;
            return hafState.a(list, map, viewModelState3, viewModelState2, haFQuestionResponse4, list3, haFQuestionResponse3);
        }

        public final HafState a(List categories, Map topQuestions, ViewModelState state, ViewModelState searchState, HaFQuestionResponse haFQuestionResponse, List list, HaFQuestionResponse haFQuestionResponse2) {
            Intrinsics.checkNotNullParameter(categories, "categories");
            Intrinsics.checkNotNullParameter(topQuestions, "topQuestions");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(searchState, "searchState");
            return new HafState(categories, topQuestions, state, searchState, haFQuestionResponse, list, haFQuestionResponse2);
        }

        public final List c() {
            return this.f107563a;
        }

        public final HaFQuestionResponse d() {
            return this.f107567e;
        }

        public final HaFQuestionResponse e() {
            return this.f107569g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HafState)) {
                return false;
            }
            HafState hafState = (HafState) obj;
            return Intrinsics.areEqual(this.f107563a, hafState.f107563a) && Intrinsics.areEqual(this.f107564b, hafState.f107564b) && Intrinsics.areEqual(this.f107565c, hafState.f107565c) && Intrinsics.areEqual(this.f107566d, hafState.f107566d) && Intrinsics.areEqual(this.f107567e, hafState.f107567e) && Intrinsics.areEqual(this.f107568f, hafState.f107568f) && Intrinsics.areEqual(this.f107569g, hafState.f107569g);
        }

        public final ViewModelState f() {
            return this.f107566d;
        }

        public final List g() {
            return this.f107568f;
        }

        public final ViewModelState h() {
            return this.f107565c;
        }

        public int hashCode() {
            int iHashCode = ((((((this.f107563a.hashCode() * 31) + this.f107564b.hashCode()) * 31) + this.f107565c.hashCode()) * 31) + this.f107566d.hashCode()) * 31;
            HaFQuestionResponse haFQuestionResponse = this.f107567e;
            int iHashCode2 = (iHashCode + (haFQuestionResponse == null ? 0 : haFQuestionResponse.hashCode())) * 31;
            List list = this.f107568f;
            int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
            HaFQuestionResponse haFQuestionResponse2 = this.f107569g;
            return iHashCode3 + (haFQuestionResponse2 != null ? haFQuestionResponse2.hashCode() : 0);
        }

        public final Map i() {
            return this.f107564b;
        }

        public String toString() {
            return "HafState(categories=" + this.f107563a + ", topQuestions=" + this.f107564b + ", state=" + this.f107565c + ", searchState=" + this.f107566d + ", chosenQuestion=" + this.f107567e + ", searchedQuestions=" + this.f107568f + ", presetQuestion=" + this.f107569g + ")";
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException
            */
        public /* synthetic */ HafState(java.util.List r9, java.util.Map r10, cz.mobilesoft.coreblock.util.ViewModelState r11, cz.mobilesoft.coreblock.util.ViewModelState r12, cz.mobilesoft.coreblock.dto.HaFQuestionResponse r13, java.util.List r14, cz.mobilesoft.coreblock.dto.HaFQuestionResponse r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
            /*
                r8 = this;
                r0 = r16 & 1
                if (r0 == 0) goto L8
                java.util.List r9 = kotlin.collections.CollectionsKt.emptyList()
            L8:
                r0 = r16 & 2
                if (r0 == 0) goto L10
                java.util.Map r10 = kotlin.collections.MapsKt.emptyMap()
            L10:
                r0 = r16 & 4
                if (r0 == 0) goto L21
                cz.mobilesoft.coreblock.util.FailedWithError r1 = new cz.mobilesoft.coreblock.util.FailedWithError
                r6 = 15
                r7 = 0
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r1.<init>(r2, r3, r4, r5, r6, r7)
                r11 = r1
            L21:
                r0 = r16 & 8
                if (r0 == 0) goto L27
                cz.mobilesoft.coreblock.util.Success r12 = cz.mobilesoft.coreblock.util.Success.f128020a
            L27:
                r0 = r16 & 16
                r1 = 0
                if (r0 == 0) goto L2d
                r13 = r1
            L2d:
                r0 = r16 & 32
                if (r0 == 0) goto L33
                r0 = r1
                goto L34
            L33:
                r0 = r14
            L34:
                r2 = r16 & 64
                if (r2 == 0) goto L43
                r17 = r1
                r14 = r12
                r15 = r13
                r16 = r0
                r12 = r10
                r13 = r11
                r10 = r8
            L41:
                r11 = r9
                goto L4d
            L43:
                r17 = r15
                r14 = r12
                r16 = r0
                r12 = r10
                r15 = r13
                r10 = r8
                r13 = r11
                goto L41
            L4d:
                r10.<init>(r11, r12, r13, r14, r15, r16, r17)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.haf.HaFRequestHelper.HafState.<init>(java.util.List, java.util.Map, cz.mobilesoft.coreblock.util.ViewModelState, cz.mobilesoft.coreblock.util.ViewModelState, cz.mobilesoft.coreblock.dto.HaFQuestionResponse, java.util.List, cz.mobilesoft.coreblock.dto.HaFQuestionResponse, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}
