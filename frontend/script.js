const chatBox = document.getElementById("chatBox");
const userInput = document.getElementById("userInput");

function addUserMessage(message) {

    const messageDiv = document.createElement("div");

    messageDiv.classList.add("message", "user-message");

    messageDiv.innerHTML = `
        <div class="message-content">
            <p>${message}</p>
        </div>
    `;

    chatBox.appendChild(messageDiv);

    chatBox.scrollTop = chatBox.scrollHeight;
}


function addBotMessage(message) {

    const messageDiv = document.createElement("div");

    messageDiv.classList.add("message", "bot-message");

    messageDiv.innerHTML = `
        <div class="message-icon">
            🤖
        </div>

        <div class="message-content">
            <p>${message}</p>
        </div>
    `;

    chatBox.appendChild(messageDiv);

    chatBox.scrollTop = chatBox.scrollHeight;
}


function getBotResponse(question) {

    const text = question.toLowerCase();


    if (text.includes("course")) {

        return "CCEW offers undergraduate and postgraduate engineering programs across multiple departments.";
    }


    if (text.includes("admission")) {

        return "For admission-related information, please refer to the official CCEW admissions section.";
    }


    if (text.includes("placement")) {

        return "CCEW has an Industry Relations and placement-related section providing information about recruitment, training and industry interaction.";
    }


    if (text.includes("facility")) {

        return "The college provides facilities including laboratories, library resources, hostels, sports facilities and other campus infrastructure.";
    }


    if (text.includes("hello") || text.includes("hi")) {

        return "Hello! 👋 How can I help you with CCEW information?";
    }


    return "I'm still learning about CCEW. Try asking about courses, admissions, placements or facilities.";
}


function sendMessage() {

    const question = userInput.value.trim();


    if (question === "") {
        return;
    }


    addUserMessage(question);


    userInput.value = "";


    setTimeout(() => {

        const response = getBotResponse(question);

        addBotMessage(response);

    }, 500);
}


function askQuestion(question) {

    userInput.value = question;

    sendMessage();
}


userInput.addEventListener("keydown", function(event) {

    if (event.key === "Enter") {

        sendMessage();

    }

});