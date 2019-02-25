package potaskun.enot.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class CustomDialogFragment extends DialogFragment{

    private Datable datable;

    /**
     * получить контекст фрагмента,
     * в качестве которого выступает класс MainActivity.
     * Так как MainActivity реализует интерфейс Datable,
     * то мы можем преобразовать контекст к данному интерфейсу
     * @param context
     */
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        datable = (Datable) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        /*получаем данные из переданого массива*/
        final String quest = getArguments().getString("phone"); //находим по ключю нужное значение
        final String id = getArguments().getString("id");

        /*Масив со значениями для списка выбора в диалоге*/
        final String[] mBals ={"Ничего", "1 Бал", "2 Бала", "3 Бала"};


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Какую оценку ставите  ? для "+id);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        //builder.setMessage("Переданные данные в окно: " + quest);
        /**
         * Создаем список из масива
         * и вешаем слушателя на нажатие ао элементу списка
         */
        builder.setItems(mBals, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int index) {
                Toast.makeText(getActivity().getApplicationContext(),
                        "За задачу: " + quest + " поставлена оценка: " + mBals[index],
                Toast.LENGTH_SHORT).show();

                datable.updateTextView(quest); //изменение текстового поля
            }
        });
        /**
         * вешаем слущателя на кнопку Ок
         */
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                datable.updateTextView(quest);
            }
        });
        builder.setNegativeButton("Отмена", null);
        builder.setCancelable(false);
        return builder.create();
    }
}
