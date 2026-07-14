import React, { useState, useEffect } from 'react';
import BookService from '../services/bookService';

const BookList = ({ onEdit }) => {
    const [books, setBooks] = useState([]);

    useEffect(() => {
        fetchBooks();
    }, []);

    const fetchBooks = async () => {
        try {
            const response = await BookService.getAllBooks();
            setBooks(response.data);
        } catch (error) {
            console.error("Error fetching books", error);
        }
    };

    const handleDelete = async (id) => {
        try {
            await BookService.deleteBook(id);
            fetchBooks(); // إعاده التحديث بعد الحذف
        } catch (error) {
            console.error("Error deleting book", error);
        }
    };

    return (
        <div className="table-container">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Book Name</th>
                        <th>ISBN</th>
                        <th>Published Date</th>
                        <th>Price</th>
                        <th>Book Type</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {books.map(book => (
                        <tr key={book.id}>
                            <td>{book.id}</td>
                            <td>{book.name}</td>
                            <td>{book.isbn}</td>
                            <td>{book.publishedDate}</td>
                            <td>{book.price}</td>
                            <td>{book.bookType}</td>
                            <td>
                                <button onClick={() => onEdit(book)}>Edit</button>
                                <button onClick={() => handleDelete(book.id)}>Delete</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default BookList;