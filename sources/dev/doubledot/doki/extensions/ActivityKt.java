package dev.doubledot.doki.extensions;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

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
public final class ActivityKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: dev.doubledot.doki.extensions.ActivityKt$bind$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass3<T> extends Lambda implements Function0<T> {
        final /* synthetic */ int $res;
        final /* synthetic */ View $this_bind;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(View view, int i3) {
            super(0);
            this.$this_bind = view;
            this.$res = i3;
        }

        /* JADX WARN: Incorrect return type in method signature: ()TT; */
        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            try {
                return this.$this_bind.findViewById(this.$res);
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }
    }

    private static final <T extends View> Lazy<T> bind(final Activity activity, final int i3) {
        return LazyKt.b(new Function0<T>() { // from class: dev.doubledot.doki.extensions.ActivityKt.bind.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                try {
                    return activity.findViewById(i3);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
        });
    }

    private static final <T extends View> T findView(Activity activity, int i3) {
        try {
            return (T) activity.findViewById(i3);
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private static final <T> T ignore(Function0<? extends T> function0) {
        try {
            return (T) function0.invoke();
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private static final <T extends View> Lazy<T> bind(final Fragment fragment, final int i3) {
        return LazyKt.b(new Function0<T>() { // from class: dev.doubledot.doki.extensions.ActivityKt.bind.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                Fragment fragment2 = fragment;
                int i4 = i3;
                View viewFindViewById = null;
                try {
                    View view = fragment2.getView();
                    if (view == null) {
                        return null;
                    }
                    try {
                        viewFindViewById = view.findViewById(i4);
                        return viewFindViewById;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return null;
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return viewFindViewById;
                }
            }
        });
    }

    private static final <T extends View> Lazy<T> bind(View view, int i3) {
        return LazyKt.b(new AnonymousClass3(view, i3));
    }

    private static final <T extends View> T findView(Fragment fragment, int i3) {
        T t2 = null;
        try {
            View view = fragment.getView();
            if (view == null) {
                return null;
            }
            try {
                t2 = (T) view.findViewById(i3);
                return t2;
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            return t2;
        }
    }

    private static final <T extends View> T findView(View view, int i3) {
        try {
            return (T) view.findViewById(i3);
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
