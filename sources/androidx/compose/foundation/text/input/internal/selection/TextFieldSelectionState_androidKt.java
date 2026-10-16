package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.contextmenu.ContextMenuState_androidKt;
import androidx.compose.foundation.text.ContextMenu_androidKt$TextItem$1;
import androidx.compose.foundation.text.MenuItemsAvailability;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TextFieldSelectionState_androidKt {
    public static final Function1 a(final TextFieldSelectionState textFieldSelectionState, final ContextMenuState contextMenuState, final State state, final Function2 function2) {
        return new Function1<ContextMenuScope, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$contextMenuBuilder$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(ContextMenuScope contextMenuScope) {
                int iM = ((MenuItemsAvailability) state.getValue()).m();
                final ContextMenuState contextMenuState2 = contextMenuState;
                TextContextMenuItems textContextMenuItems = TextContextMenuItems.f9893b;
                boolean zH = MenuItemsAvailability.h(iM);
                final Function2 function22 = function2;
                final TextFieldSelectionState textFieldSelectionState2 = textFieldSelectionState;
                if (zH) {
                    ContextMenuScope.d(contextMenuScope, new ContextMenu_androidKt$TextItem$1(textContextMenuItems), null, false, null, new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m92invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m92invoke() {
                            function22.invoke(textFieldSelectionState2, TextContextMenuItems.f9893b);
                            ContextMenuState_androidKt.a(contextMenuState2);
                        }
                    }, 14, null);
                }
                final ContextMenuState contextMenuState3 = contextMenuState;
                TextContextMenuItems textContextMenuItems2 = TextContextMenuItems.f9894c;
                boolean zG = MenuItemsAvailability.g(iM);
                final Function2 function23 = function2;
                final TextFieldSelectionState textFieldSelectionState3 = textFieldSelectionState;
                if (zG) {
                    ContextMenuScope.d(contextMenuScope, new ContextMenu_androidKt$TextItem$1(textContextMenuItems2), null, false, null, new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m93invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m93invoke() {
                            function23.invoke(textFieldSelectionState3, TextContextMenuItems.f9894c);
                            ContextMenuState_androidKt.a(contextMenuState3);
                        }
                    }, 14, null);
                }
                final ContextMenuState contextMenuState4 = contextMenuState;
                TextContextMenuItems textContextMenuItems3 = TextContextMenuItems.f9895d;
                boolean zI = MenuItemsAvailability.i(iM);
                final Function2 function24 = function2;
                final TextFieldSelectionState textFieldSelectionState4 = textFieldSelectionState;
                if (zI) {
                    ContextMenuScope.d(contextMenuScope, new ContextMenu_androidKt$TextItem$1(textContextMenuItems3), null, false, null, new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m94invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m94invoke() {
                            function24.invoke(textFieldSelectionState4, TextContextMenuItems.f9895d);
                            ContextMenuState_androidKt.a(contextMenuState4);
                        }
                    }, 14, null);
                }
                final ContextMenuState contextMenuState5 = contextMenuState;
                TextContextMenuItems textContextMenuItems4 = TextContextMenuItems.f9896f;
                boolean zJ = MenuItemsAvailability.j(iM);
                final Function2 function25 = function2;
                final TextFieldSelectionState textFieldSelectionState5 = textFieldSelectionState;
                if (zJ) {
                    ContextMenuScope.d(contextMenuScope, new ContextMenu_androidKt$TextItem$1(textContextMenuItems4), null, false, null, new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m95invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m95invoke() {
                            function25.invoke(textFieldSelectionState5, TextContextMenuItems.f9896f);
                            ContextMenuState_androidKt.a(contextMenuState5);
                        }
                    }, 14, null);
                }
                final ContextMenuState contextMenuState6 = contextMenuState;
                TextContextMenuItems textContextMenuItems5 = TextContextMenuItems.f9897g;
                boolean zF = MenuItemsAvailability.f(iM);
                final Function2 function26 = function2;
                final TextFieldSelectionState textFieldSelectionState6 = textFieldSelectionState;
                if (zF) {
                    ContextMenuScope.d(contextMenuScope, new ContextMenu_androidKt$TextItem$1(textContextMenuItems5), null, false, null, new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m96invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m96invoke() {
                            function26.invoke(textFieldSelectionState6, TextContextMenuItems.f9897g);
                            ContextMenuState_androidKt.a(contextMenuState6);
                        }
                    }, 14, null);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((ContextMenuScope) obj);
                return Unit.f139807a;
            }
        };
    }
}
