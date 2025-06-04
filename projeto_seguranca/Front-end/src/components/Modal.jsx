import React, { useEffect, useRef } from 'react';
import ReactDOM from 'react-dom';
import { FaXmark } from 'react-icons/fa6';


const MODAL_STYLES = {
  position: "fixed",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  backgroundColor: "#fff",
  padding: "20px",
  zIndex: 1000,
  borderRadius: "8px",
};

const OVERLAY_STYLES = {
  position: "fixed",
  top: 0,
  left: 0,
  right: 0,
  bottom: 0,
  backgroundColor: "rgba(0, 0, 0, 0.5)",
  zIndex: 1000,
};


function Modal({ isOpen, onClose, children, portalId = 'modal-root', ariaLabel = 'Modal', modalId = 'modal-dialog' }) {
    const el = document.createElement('div');
    const modalRef = useRef(null);
    const closeButtonRef = useRef(null);

    useEffect(() => {
        if (!isOpen) return;

        const modalRoot = document.getElementById(portalId);
        modalRoot.appendChild(el);
        
        if (modalRef.current) {
            modalRef.current.focus();
        }

        const handleKeyDown = (e) => {
            if (e.key === 'Escape') {
                onClose();
            }
            if (e.key === 'Tab') {
                if (!modalRef.current?.contains(e.target)) {
                    e.preventDefault();
                    closeButtonRef.current?.focus();
                }
            }
        };

        document.addEventListener('keydown', handleKeyDown);
        
        document.body.setAttribute('aria-hidden', 'true');
        document.body.classList.add('overflow-hidden');

        return () => {
            modalRoot.removeChild(el);
            document.removeEventListener('keydown', handleKeyDown);
            document.body.removeAttribute('aria-hidden');
            document.body.classList.remove('overflow-hidden');
        };
    }, [isOpen, portalId, onClose, el]);

    if (!isOpen) return null;

    return ReactDOM.createPortal(
        <div 
            role="dialog"
            aria-modal="true"
            aria-labelledby={modalId}
            aria-label={ariaLabel}
            tabIndex={-1}
            ref={modalRef}
            style={OVERLAY_STYLES}
            onClick={onClose}
        >
            <div 
                id={modalId}
                style={MODAL_STYLES}
                onClick={e => e.stopPropagation()}
                role="document"
            >
                <button
                    ref={closeButtonRef}
                    onClick={onClose}
                    className="absolute top-4 right-4 p-1 text-gray-600 hover:text-gray-900 focus:outline-none focus:ring-2 focus:ring-blue-500 rounded"
                    aria-label="Fechar modal"
                >
                    <FaXmark aria-hidden="true" />
                </button>
                
                {children}
            </div>
        </div>,
        el
    );
};


const ModalHeader = ({ children }) => (
    <div className="mb-4">
        {children}
    </div>
);


Modal.Header = ModalHeader;

export default Modal;