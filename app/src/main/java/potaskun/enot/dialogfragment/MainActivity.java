package potaskun.enot.dialogfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView phoneList = findViewById(R.id.phonesList);
        /**
         * массив значений для списка
         */
        ArrayList<String> phone = new ArrayList<>();
        phone.add("phone1");
        phone.add("phone2");
        phone.add("phone3");
        phone.add("phone4");
        phone.add("phone5");

        /*создаем адаптер в который помещаем наш массив, для каждого элемента масива применяется шаблон по умолчанию*/
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, phone);
        /*Назначаем нашему ListView созданый адаптер с значениями*/
        phoneList.setAdapter(adapter);

        /* Вешаем слушателя на нажатия по элементу ListView */
        phoneList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                /*Получаем значение элемента по его номеру в адаптере*/
                String selectedPhone = adapter.getItem(position);
                System.out.println("selectPhone: " + selectedPhone);//for test

                Bundle args = new Bundle();//создаем массив для передачи данных между активити и фрагментом
                args.putString("phone", selectedPhone);//помещаем в нее выбраное значение "key"=>"item"

                CustomDialogFragment dialog = new CustomDialogFragment(); //Создаем новый класс фрагмента
                /*Передаем наш массив с нужными переменными в диалог*/
                dialog.setArguments(args);
                /*Вызываем диалог*/
                dialog.show(getSupportFragmentManager(),"custom");
            }
        });
    }

    /**
     * Срабатывает при нажатии кнопки (У нее заложено событие OnClick))
     * @param view
     */
    public void showDialog(View view) {
        CustomDialogFragment dialog = new CustomDialogFragment();
        dialog.show(getSupportFragmentManager(), "custom");
    }
}
