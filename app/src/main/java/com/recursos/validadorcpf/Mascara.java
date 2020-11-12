package com.recursos.validadorcpf;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class Mascara {
    public static TextWatcher mask(final EditText editTxt, final String mask) {
        return new TextWatcher() {
            boolean isUpdating;
            String old = "";

            @Override
            public void afterTextChanged(final Editable s) {
            }

            ;

            @Override
            public void beforeTextChanged(final CharSequence s, final int start, final int count, final int after) {
            }

            ;

            @Override
            public void onTextChanged(final CharSequence s, final int start, final int before, final int count) {
                final String str = Mascara.unmask(s.toString());
                String mascara = "";
                if (isUpdating) {
                    old = str;
                    isUpdating = false;
                    return;
                }
                int i = 0;
                for (final char m : mask.toCharArray()) {
                    if (m != '#' && str.length() > old.length()) {
                        mascara += m;
                        continue;
                    }
                    try {
                        mascara += str.charAt(i);
                    } catch (final Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                editTxt.setText(mascara);
                editTxt.setSelection(mascara.length());
            }

        };
    }

    public static String unmask(final String s) {
        return s.replaceAll("[.]", "").replaceAll("[-]", "")
                .replaceAll("[/]", "").replaceAll("[(]", "")
                .replaceAll("[ ]", "").replaceAll("[:]", "")
                .replaceAll("[)]", "");
    }
}
