package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ToolbarUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator f81297a = new Comparator<View>() { // from class: com.google.android.material.internal.ToolbarUtils.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            return view.getTop() - view2.getTop();
        }
    };

    public static ActionMenuItemView a(Toolbar toolbar, int i3) {
        ActionMenuView actionMenuViewB = b(toolbar);
        if (actionMenuViewB == null) {
            return null;
        }
        for (int i4 = 0; i4 < actionMenuViewB.getChildCount(); i4++) {
            View childAt = actionMenuViewB.getChildAt(i4);
            if (childAt instanceof ActionMenuItemView) {
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) childAt;
                if (actionMenuItemView.getItemData().getItemId() == i3) {
                    return actionMenuItemView;
                }
            }
        }
        return null;
    }

    public static ActionMenuView b(Toolbar toolbar) {
        for (int i3 = 0; i3 < toolbar.getChildCount(); i3++) {
            View childAt = toolbar.getChildAt(i3);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private static ImageView c(Toolbar toolbar, Drawable drawable) {
        ImageView imageView;
        Drawable drawable2;
        if (drawable == null) {
            return null;
        }
        for (int i3 = 0; i3 < toolbar.getChildCount(); i3++) {
            View childAt = toolbar.getChildAt(i3);
            if ((childAt instanceof ImageView) && (drawable2 = (imageView = (ImageView) childAt).getDrawable()) != null && drawable2.getConstantState() != null && drawable2.getConstantState().equals(drawable.getConstantState())) {
                return imageView;
            }
        }
        return null;
    }

    public static ImageView d(Toolbar toolbar) {
        return c(toolbar, toolbar.getLogo());
    }

    public static ImageButton e(Toolbar toolbar) {
        Drawable navigationIcon = toolbar.getNavigationIcon();
        if (navigationIcon == null) {
            return null;
        }
        for (int i3 = 0; i3 < toolbar.getChildCount(); i3++) {
            View childAt = toolbar.getChildAt(i3);
            if (childAt instanceof ImageButton) {
                ImageButton imageButton = (ImageButton) childAt;
                if (imageButton.getDrawable() == navigationIcon) {
                    return imageButton;
                }
            }
        }
        return null;
    }

    public static TextView f(Toolbar toolbar) {
        List listG = g(toolbar, toolbar.getSubtitle());
        if (listG.isEmpty()) {
            return null;
        }
        return (TextView) Collections.max(listG, f81297a);
    }

    private static List g(Toolbar toolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < toolbar.getChildCount(); i3++) {
            View childAt = toolbar.getChildAt(i3);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }

    public static TextView h(Toolbar toolbar) {
        List listG = g(toolbar, toolbar.getTitle());
        if (listG.isEmpty()) {
            return null;
        }
        return (TextView) Collections.min(listG, f81297a);
    }
}
