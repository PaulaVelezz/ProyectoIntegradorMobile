package com.example.planetsuperheroes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.planetsuperheroes.R;
import com.example.planetsuperheroes.models.Order;
import com.example.planetsuperheroes.models.OrderItem;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private final List<Order> listaOrders;

    public OrderAdapter(List<Order> listaOrders) {
        this.listaOrders = listaOrders;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        Order order = listaOrders.get(position);

        // Asignar valores a los TextView con manejo de null
        holder.textViewUser.setText(order.getUser() != null ? order.getUser() : "N/A");
        holder.textViewState.setText(order.getState() != null ? order.getState() : "N/A");
        holder.textViewOrderDate.setText(order.getOrderDate() != null ? order.getOrderDate() : "N/A");
        holder.textViewPaymentMethod.setText(order.getPaymentMethod() != null ? order.getPaymentMethod() : "N/A");
        holder.textViewShippingMethod.setText(order.getShippingMethod() != null ? order.getShippingMethod() : "N/A");
        holder.textViewPaymentStatus.setText(order.getPaymentStatus() != null ? order.getPaymentStatus() : "N/A");
        holder.textViewTotalAmount.setText(order.getTotalAmount() != null ? order.getTotalAmount().toString() : "0.00");


        // Mostrar los items de la orden
//        StringBuilder itemsText = new StringBuilder();
//        if (order.getOrderItems() != null && !order.getOrderItems().isEmpty()) {
//            for (OrderItem item : order.getOrderItems()) {
//                String productName = item.getProduct() != null ? item.getProduct() : "N/A"; // Asegúrate de que getProduct() retorna un String.
//                itemsText.append("Producto: ").append(productName)
//                        .append(", Cantidad: ").append(item.getQuantity()).append("\n");
//            }
//        } else {
//            itemsText.append("No hay artículos en esta orden.");
//        }
   //     holder.textViewOrderItems.setText(itemsText.toString());
    }

    @Override
    public int getItemCount() {
        return listaOrders.size();
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView textViewUser, textViewState, textViewOrderDate, textViewPaymentMethod, textViewShippingMethod, textViewPaymentStatus, textViewTotalAmount, textViewOrderItems;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewUser = itemView.findViewById(R.id.textViewUser);
            textViewState = itemView.findViewById(R.id.textViewState);
            textViewOrderDate = itemView.findViewById(R.id.textViewOrderDate);
            textViewPaymentMethod = itemView.findViewById(R.id.textViewPaymentMethod);
            textViewShippingMethod = itemView.findViewById(R.id.textViewShippingMethod);
            textViewPaymentStatus = itemView.findViewById(R.id.textViewPaymentStatus);
            textViewTotalAmount = itemView.findViewById(R.id.textViewTotalAmount);
            textViewOrderItems = itemView.findViewById(R.id.textViewOrderItems);
        }
    }
}