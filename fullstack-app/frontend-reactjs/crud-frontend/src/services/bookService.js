import axios from 'axios';

const API_BASE_URL = "http://localhost:8080/api/books";

class BookService {
    getAllBooks() {
        return axios.get(API_BASE_URL);
    }
    
    // إضافة /addBook لتطابق الـ Backend
    addBook(book) {
        return axios.post(`${API_BASE_URL}/addBook`, book);
    }
    
    // إضافة /updateBook لتطابق الـ Backend
    updateBook(id, book) {
        return axios.put(`${API_BASE_URL}/updateBook/${id}`, book);
    }
    
    // إضافة /deleteBook لتطابق الـ Backend
    deleteBook(id) {
        return axios.delete(`${API_BASE_URL}/deleteBook/${id}`);
    }
}

const bookServiceInstance = new BookService();
export default bookServiceInstance;